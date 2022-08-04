package com.pfa.ecommerce.services.impl;

import com.pfa.ecommerce.entities.FactureEntity;
import com.pfa.ecommerce.mappers.FactureMapper;
import com.pfa.ecommerce.mappers.PersonneMapper;
import com.pfa.ecommerce.model.Article;
import com.pfa.ecommerce.model.Facture;
import com.pfa.ecommerce.repository.FactureRepository;
import com.pfa.ecommerce.services.intf.IFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.file.LinkOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FactureServiceImpl implements IFactureService {
    @Autowired
    FactureRepository factureRepository;
    public List<Facture> getAll() {

        return FactureMapper.INSTANCE.mapToModels(factureRepository.findAll());
    }

    public Optional<Facture> findById(Integer id) {

        return factureRepository.findById(id).map(FactureMapper.INSTANCE::mapToModel);
    }

     public Facture save(Facture facture) {

         return FactureMapper.INSTANCE.mapToModel(factureRepository.save(FactureMapper.INSTANCE.mapToEntity(facture)));
    }

    public Facture update(Integer Id,Facture facture) {

             return FactureMapper.INSTANCE.mapToModel(factureRepository.save(FactureMapper.INSTANCE.mapToEntity(facture)));
        }

    public Boolean delete(Integer code) {
        Optional<FactureEntity> fact =factureRepository.findById(code);
        if(fact.isPresent()) { factureRepository.deleteById(code); }
    return true;}


}
