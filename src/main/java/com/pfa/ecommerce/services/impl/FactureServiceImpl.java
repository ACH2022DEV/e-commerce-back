package com.pfa.ecommerce.services.impl;

import com.pfa.ecommerce.entities.dto.CreateFacture;
import com.pfa.ecommerce.entities.ArticleFactureEntity;
import com.pfa.ecommerce.entities.FactureEntity;
import com.pfa.ecommerce.mappers.ArticleFactureMapper;
import com.pfa.ecommerce.mappers.FactureMapper;
import com.pfa.ecommerce.model.Facture;
import com.pfa.ecommerce.repository.ArticleFactureRepository;
import com.pfa.ecommerce.repository.ArticleRepository;
import com.pfa.ecommerce.repository.FactureRepository;
import com.pfa.ecommerce.repository.PersonneRepository;
import com.pfa.ecommerce.services.intf.IFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class FactureServiceImpl implements IFactureService {
    @Autowired
    FactureRepository factureRepository;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    PersonneRepository personneRepository;
    @Autowired
    ArticleFactureRepository articleFactureRepository;

    public List<Facture> getAll() {

        return FactureMapper.INSTANCE.mapToModels(factureRepository.findAll());
    }

    public Optional<Facture> findById(Long id) {
        return factureRepository.findById(id).map(FactureMapper.INSTANCE::mapToModel);
    }

   /* public Facture save(Facture facture) {

        return FactureMapper.INSTANCE.mapToModel(factureRepository.save(FactureMapper.INSTANCE.mapToEntity(facture)));
    }*/
    public Facture update(Facture facture) {


        List<Long> codeArtciles = articleFactureRepository.findAll().stream()
                .filter(e -> e.getFacture().getCode().equals(facture.getCode()))
                .map(e -> e.getArticle().getCodeArticle())
                .collect(Collectors.toList());


        facture.getArticles().forEach(art -> {
            ArticleFactureEntity articleToUpdate = ArticleFactureMapper.INSTANCE.mapToEntity(art);
            factureRepository.findById(facture.getCode()).ifPresent(articleToUpdate::setFacture);
            articleFactureRepository.save(articleToUpdate);
        });


        List<Long> codesRecus = facture.getArticles().stream().map(e -> e.getArticle().getCodeArticle()).collect(Collectors.toList());

        codeArtciles.stream().filter(e -> !codesRecus.contains(e)).forEach(e -> {
            articleFactureRepository.findbyArticleIdandFactureId(facture.getCode(), e).ifPresent(eToDelete -> {
                articleFactureRepository.delete(eToDelete);
            });
        });


        return factureRepository.findById(facture.getCode()).map(FactureMapper.INSTANCE::mapToModel).orElse(null);
    }



    public boolean delete(Long code) {
        Optional<FactureEntity> fact = factureRepository.findById(code);
        if (fact.isPresent()) {
            factureRepository.deleteById(code);
        }
        return true;
    }
    public Facture save(CreateFacture facture) {
        FactureEntity newfacture = new FactureEntity();
        personneRepository.findById(facture.getIdPersonne()).ifPresent(newfacture::setPersonne);
        FactureEntity savedfacture = factureRepository.save(newfacture);
        facture.getArticles().forEach(art -> {
            ArticleFactureEntity articleFactureEntity = new ArticleFactureEntity();
            articleFactureEntity.setFacture(savedfacture);
            articleRepository.findById(art.getCodeArticle()).ifPresent(articleFactureEntity::setArticle);
            articleFactureEntity.setQuatite(art.getQuatite());
            // save devisArticleEntity
            articleFactureRepository.save(articleFactureEntity);

        });

        return FactureMapper.INSTANCE.mapToModel(savedfacture);
    }

}
