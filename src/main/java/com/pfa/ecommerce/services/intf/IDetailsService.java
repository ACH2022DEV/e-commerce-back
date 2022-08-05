package com.pfa.ecommerce.services.intf;

import com.pfa.ecommerce.model.Details;
import com.pfa.ecommerce.model.Devis;

import java.util.List;
import java.util.Optional;

public interface IDetailsService {
    public boolean delete(Long Code);
    public Details update( Details details);
    public Details save(Details details);
    public Optional<Details> findById(Long id);
    public List<Details> getAll();
    
}
