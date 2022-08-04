package com.pfa.ecommerce.services.impl;

import com.pfa.ecommerce.entities.DetailsEntity;
import com.pfa.ecommerce.entities.DevisEntity;
import com.pfa.ecommerce.mappers.DetailsMapper;
import com.pfa.ecommerce.mappers.PersonneMapper;
import com.pfa.ecommerce.model.Details;
import com.pfa.ecommerce.model.Devis;
import com.pfa.ecommerce.repository.DetailsRepository;
import com.pfa.ecommerce.repository.DevisRepository;
import com.pfa.ecommerce.services.intf.IDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DetailsServiceImpl implements IDetailsService {

    @Autowired
    DetailsRepository detailsRepository;

    public List<Details> getAll() {
        return DetailsMapper.INSTANCE.mapToModels(detailsRepository.findAll());
    }

    public Optional<Details> findById(Integer id) {
        return detailsRepository.findById(id).map(DetailsMapper.INSTANCE::mapToModel);
    }

    public Details save(Details details) {

        return DetailsMapper.INSTANCE.mapToModel(detailsRepository.save(DetailsMapper.INSTANCE.mapToEntity(details)));
    }
    public Details update( Integer Code , Details details) {

            return DetailsMapper.INSTANCE.mapToModel(detailsRepository.save(DetailsMapper.INSTANCE.mapToEntity(details)));
        }


  public boolean delete(Integer Code) {
        Optional<DetailsEntity> ar =detailsRepository.findById(Code);
        if(ar.isPresent()) {
            detailsRepository.deleteById(Code); }
        return true;}


}


