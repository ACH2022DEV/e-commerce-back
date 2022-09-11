package com.pfa.ecommerce.services.impl;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.PanierEntity;
import com.pfa.ecommerce.entities.dto.CreateUpdatePanierDto;
import com.pfa.ecommerce.mappers.PanierMapper;
import com.pfa.ecommerce.model.Article;
import com.pfa.ecommerce.model.Panier;
import com.pfa.ecommerce.repository.ArticleRepository;
import com.pfa.ecommerce.repository.PanierRepository;
import com.pfa.ecommerce.repository.PersonneRepository;
import com.pfa.ecommerce.services.intf.IPanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PanierServiceImp implements IPanierService {
    @Autowired
    PanierRepository panierRepository;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    ArticleServiceImpl articleService;
    @Autowired
    PersonneServiceImpl personneService;

    @Autowired
    PersonneRepository personneRepository;

    public List<Panier> getAll() {

        return PanierMapper.INSTANCE.mapToModels(panierRepository.findAll());
    }

    @Override
    public Optional<Panier> findById(Long id) {
        return panierRepository.findById(id).map(PanierMapper.INSTANCE::mapToModel);
    }


    //IL ESTobligatoire d'utiliser authentification (token )
    // la premiere Methode
    @Override
    public void save(CreateUpdatePanierDto panier) {
        panierRepository.findbyPersonneId(panier.getIdPersonne()).forEach(panToDelete -> {
            panierRepository.delete(panToDelete);
        });

        panier.getPaniers().forEach(pan -> {
            PanierEntity panierEntityToSave = new PanierEntity();
            // il faut que l'article soit présent
            articleRepository.findById(pan.getCodeArticle())
                    .map(art -> {
                        panierEntityToSave.setArticle(art);
                        return panierEntityToSave;
                    })
                    .orElseThrow(() -> new RuntimeException("Artcile inexistant"));
            panierEntityToSave.setQuantity(pan.getQuantity());
            panierEntityToSave.setDate(LocalDateTime.now());
            // il faut que la personne soit présente
            personneRepository.findById(panier.getIdPersonne()).map(per -> {
                panierEntityToSave.setPersonne(per);
                return panierEntityToSave;
            }).orElseThrow(() -> new RuntimeException("Personnes inexistante"));
            panierRepository.save(panierEntityToSave);
        });
    }



    public boolean delete(Long id) {
        Optional<PanierEntity> a = panierRepository.findById(id);
        if (a.isPresent()) {
            panierRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
