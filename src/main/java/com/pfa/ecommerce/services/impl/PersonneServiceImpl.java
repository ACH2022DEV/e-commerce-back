package com.pfa.ecommerce.services.impl;

import com.pfa.ecommerce.entities.PersonneEntity;
import com.pfa.ecommerce.mappers.ArticleMapper;
import com.pfa.ecommerce.mappers.PersonneMapper;
import com.pfa.ecommerce.model.Personne;
import com.pfa.ecommerce.repository.PersonneRepository;
import com.pfa.ecommerce.services.intf.IPersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonneServiceImpl implements IPersonneService {

    @Autowired
    private PersonneRepository personneRepository;


    public Personne save(Personne personne) {
        return PersonneMapper.INSTANCE.mapToModel(personneRepository.save(PersonneMapper.INSTANCE.mapToEntity(personne)));
    }

    @Override
    public List<Personne> findAll(int pageNo ) {
        Pageable paging = PageRequest.of(pageNo, 6);
        Page<PersonneEntity> pagedResult = personneRepository.findAll(paging);
        //int totalElements = (int) pagedResult.getTotalElements();
        List<PersonneEntity> PpersonneList = pagedResult.getContent();
       //int[] pages=new int[pagedResult.getTotalPages()];


        return PersonneMapper.INSTANCE.mapToModels(PpersonneList);


    }

    @Override
    public Optional<Personne> findById(Long id) {
       return personneRepository.findById(id).map(PersonneMapper.INSTANCE::mapToModel);
    }

    public Personne update(Personne personne) {
        // ajouter un test pour vérifier si la personne existe en base
        return PersonneMapper.INSTANCE.mapToModel(personneRepository.save(PersonneMapper.INSTANCE.mapToEntity(personne)));
    }


    public boolean delete(Long id) {
        Optional<PersonneEntity> a = personneRepository.findById(id);
        if (a.isPresent()) {
            personneRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
