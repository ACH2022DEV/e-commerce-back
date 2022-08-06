package com.pfa.ecommerce.services.impl;

import com.pfa.ecommerce.entities.DevisEntity;
import com.pfa.ecommerce.mappers.DevisMapper;
import com.pfa.ecommerce.model.Devis;
import com.pfa.ecommerce.repository.DevisRepository;
import com.pfa.ecommerce.services.intf.IDevisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DevisServiceImpl implements IDevisService {

    @Autowired
    DevisRepository devisRepository;

    public List<Devis> getAll() {
        return DevisMapper.INSTANCE.mapToModels(devisRepository.findAll());
    }

    public Optional<Devis> findById(Long id) {
        return devisRepository.findById(id).map(DevisMapper.INSTANCE::mapToModel);
    }

     public Devis save(Devis devis) {

         return DevisMapper.INSTANCE.mapToModel(devisRepository.save(DevisMapper.INSTANCE.mapToEntity(devis)));
    }
    public Devis update(  Devis devis) {

         return DevisMapper.INSTANCE.mapToModel(devisRepository.save(DevisMapper.INSTANCE.mapToEntity(devis)));
        }


     public boolean delete(Long CodeDevis) {
        Optional<DevisEntity> ar =devisRepository.findById(CodeDevis);
        if(ar.isPresent()) {
        devisRepository.deleteById(CodeDevis); }
    return true;}


}

