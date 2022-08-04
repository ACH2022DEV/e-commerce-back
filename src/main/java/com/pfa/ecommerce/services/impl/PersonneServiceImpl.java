package com.pfa.ecommerce.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.pfa.ecommerce.mappers.PersonneMapper;
import com.pfa.ecommerce.model.Personne;
import com.pfa.ecommerce.services.intf.IPersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.ecommerce.entities.PersonneEntity;
import com.pfa.ecommerce.repository.PersonneRepository;

@Service
@Transactional
public class PersonneServiceImpl implements IPersonneService {

    @Autowired
    private PersonneRepository personneRepository;


    public Personne save(Personne personne) {
        return PersonneMapper.INSTANCE.mapToModel(personneRepository.save(PersonneMapper.INSTANCE.mapToEntity(personne)));
    }

    @Override
    public List<Personne> findAll() {

        return PersonneMapper.INSTANCE.mapToModels(personneRepository.findAll());
    }

    @Override
    public Optional<Personne> findById(Long id) {
       return personneRepository.findById(id).map(PersonneMapper.INSTANCE::mapToModel);
    }

    public Personne update(Long id, Personne personne) {
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
