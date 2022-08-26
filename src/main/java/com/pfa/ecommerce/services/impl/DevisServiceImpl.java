package com.pfa.ecommerce.services.impl;

import com.pfa.ecommerce.entities.dto.CreateDevis;
import com.pfa.ecommerce.entities.DevisArticleEntity;
import com.pfa.ecommerce.entities.DevisEntity;
import com.pfa.ecommerce.mappers.DevisArticleMapper;
import com.pfa.ecommerce.mappers.DevisMapper;
import com.pfa.ecommerce.model.Devis;
import com.pfa.ecommerce.repository.ArticleRepository;
import com.pfa.ecommerce.repository.DevisArticleRepository;
import com.pfa.ecommerce.repository.DevisRepository;
import com.pfa.ecommerce.repository.PersonneRepository;
import com.pfa.ecommerce.services.intf.IDevisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class DevisServiceImpl implements IDevisService {

    @Autowired
    DevisRepository devisRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    DevisArticleRepository devisArticleRepository;

    @Autowired
    PersonneRepository personneRepository;

    public List<Devis> getAll() {
        return DevisMapper.INSTANCE.mapToModels(devisRepository.findAll());
    }

    public Optional<Devis> findById(Long id) {
        return devisRepository.findById(id).map(DevisMapper.INSTANCE::mapToModel);
    }

    /*public Devis save(Devis devis) {

        return DevisMapper.INSTANCE.mapToModel(devisRepository.save(DevisMapper.INSTANCE.mapToEntity(devis)));
    }*/

    public Devis update(Devis devis) {

        // 1 2 5

        // 1 2 4



        // nous devons pas modifier les informations de la personnes
        List<Long> codeArtciles = devisArticleRepository.findAll().stream()
                .filter(e-> e.getDevis().getCodedevis().equals(devis.getCodedevis()))
                .map(e -> e.getArticle().getCodeArticle())
                .collect(Collectors.toList());


        devis.getArticles().forEach(art -> {
            DevisArticleEntity articleToUpdate = DevisArticleMapper.INSTANCE.mapToEntity(art);
            devisRepository.findById(devis.getCodedevis()).ifPresent(articleToUpdate::setDevis);
            devisArticleRepository.save(articleToUpdate);
        });
        List<Long> newCodes = devis.getArticles().stream().map(e ->e.getArticle().getCodeArticle()).collect(Collectors.toList());

        codeArtciles.stream().filter(e -> !newCodes.contains(e)).forEach(e -> {
            /*devisArticleRepository.findById(e, devis.getCodedevis()).ifPresent(eToDelete ->{
                devisArticleRepository.delete(eToDelete);
                System.out.println("tot");
            });*/
        });

        // il faut gérer le cas de a suppression
        return devisRepository.findById(devis.getCodedevis()).map(DevisMapper.INSTANCE::mapToModel).orElse(null);
    }


    public boolean delete(Long CodeDevis) {
        Optional<DevisEntity> ar = devisRepository.findById(CodeDevis);
        if (ar.isPresent()) {
            devisRepository.deleteById(CodeDevis);
        }
        return true;
    }

    @Override
    public Devis save(CreateDevis devis) {
        DevisEntity newDevis = new DevisEntity();
        personneRepository.findById(devis.getIdPersonne()).ifPresent(newDevis::setPersonne);
        DevisEntity savedDevis = devisRepository.save(newDevis);

        devis.getArticles().forEach(art -> {
            DevisArticleEntity devisArticleEntity = new DevisArticleEntity();
            devisArticleEntity.setDevis(savedDevis);
            articleRepository.findById(art.getCodeArticle()).ifPresent(devisArticleEntity::setArticle);
            devisArticleEntity.setQuatite(art.getQuatite());
            // save devisArticleEntity
            devisArticleRepository.save(devisArticleEntity);

        });
        return DevisMapper.INSTANCE.mapToModel(savedDevis);
    }


}

