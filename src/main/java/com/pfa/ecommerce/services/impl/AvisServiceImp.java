package com.pfa.ecommerce.services.impl;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.AvisEntity;
import com.pfa.ecommerce.entities.dto.CreateAvisDto;
import com.pfa.ecommerce.mappers.ArticleMapper;
import com.pfa.ecommerce.mappers.AvisMapper;
import com.pfa.ecommerce.model.Article;
import com.pfa.ecommerce.model.Avis;
import com.pfa.ecommerce.repository.ArticleRepository;
import com.pfa.ecommerce.repository.AvisRepository;
import com.pfa.ecommerce.repository.PersonneRepository;
import com.pfa.ecommerce.services.intf.IAvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AvisServiceImp implements IAvisService {


    @Autowired
    AvisRepository avisRepository;
    @Autowired
    PersonneRepository personneRepository;
    @Autowired
    ArticleRepository articleRepository;


    @Override
    public Page<Avis> getSearch(Pageable pageable, Integer NbEtoile) {
        Page<AvisEntity> avisEntityPage = avisRepository.findBySearch(pageable,NbEtoile);
        List<AvisEntity> avisEntityList = avisEntityPage.stream().toList();
        List<Avis> avisList =
                AvisMapper.INSTANCE.mapToModels(avisEntityList.stream().toList());


        return new PageImpl<>(avisList, pageable, avisEntityPage.getTotalElements());
    }
    public List<Avis> getAll() {
        return AvisMapper.INSTANCE.mapToModels(avisRepository.findAll());
    }


    public Optional<Avis> findById(Long id) {
        return avisRepository.findById(id).map(AvisMapper.INSTANCE::mapToModel);
    }

    @Override
    public void save(CreateAvisDto avis) {

       /*     avisRepository.findbyPersonneId(avis.getIdPersonne()).forEach(avisToDelete -> {
                avisRepository.delete(avisToDelete);
            });*/

        avis.getAvis().forEach(avi -> {

            AvisEntity avisEntityToSave = new AvisEntity();
            if (avis.getAvis() != null) {
                avisEntityToSave.setEtoile(avi.getEtoile());
                avisEntityToSave.setMessage(avi.getMessage());
                avisEntityToSave.setDateAvis(LocalDateTime.now());

            articleRepository.findById(avi.getCodeArticle())
                    .map(monavis -> {
                        avisEntityToSave.setArticle(monavis);
                        return avisEntityToSave;
                    });
            }
            // il faut que la personne soit présente
            personneRepository.findById(avis.getIdPersonne()).map(per -> {
                avisEntityToSave.setPersonne(per);
                return avisEntityToSave;
            });

            avisRepository.save(avisEntityToSave);
        });
    }



    public boolean delete(Long id) {

        Optional<AvisEntity> ar = avisRepository.findById(id);
        if (ar.isPresent()) {
            avisRepository.deleteById(id);
        }
        return true;
    }

}
