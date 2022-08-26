package com.pfa.ecommerce.services.impl;

import com.pfa.ecommerce.entities.PanierEntity;
import com.pfa.ecommerce.entities.dto.CreatePanier;
import com.pfa.ecommerce.mappers.FactureMapper;
import com.pfa.ecommerce.mappers.PanierMapper;
import com.pfa.ecommerce.model.Panier;
import com.pfa.ecommerce.repository.ArticleRepository;
import com.pfa.ecommerce.repository.PanierRepository;
import com.pfa.ecommerce.repository.PersonneRepository;
import com.pfa.ecommerce.services.intf.IPanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
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



    @Override
    public Panier update(Panier panier) {
        return PanierMapper.INSTANCE.mapToModel(panierRepository.save(PanierMapper.INSTANCE.mapToEntity(panier)));
    }

    //IL ESTobligatoire d'utiliser authentification (token )
    public void save(CreatePanier createPanier) {

        PanierEntity newpanier=new PanierEntity();
        personneRepository.findById(createPanier.getIdPersonne()).ifPresent(newpanier::setPersonne);
        createPanier.getPanierArticle().forEach(art -> {

            newpanier.setQuantity(art.getQuantity());
            articleRepository.findById(art.getCodeArticle()).ifPresent(newpanier::setArticle);
            newpanier.setDate(new Date());


        });
    }










    public Boolean delete(Long id) {
        Optional<PanierEntity> a = panierRepository.findById(id);
        if (a.isPresent()) {
            panierRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
