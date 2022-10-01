package com.pfa.ecommerce.services.intf;

import com.pfa.ecommerce.entities.dto.CreateDevis;
import com.pfa.ecommerce.model.Devis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IDevisService {
    public Devis update( Devis devis);
    public boolean delete(Long id);
    public Devis save(CreateDevis devis);
    public Optional<Devis> findById(Long id);
    public Page<Devis> getAll(Pageable pageable) ;
}
