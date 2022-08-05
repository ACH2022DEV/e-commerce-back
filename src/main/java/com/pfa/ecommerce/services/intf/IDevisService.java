package com.pfa.ecommerce.services.intf;

import com.pfa.ecommerce.model.Devis;

import java.util.List;
import java.util.Optional;

public interface IDevisService {
    public Devis update( Devis devis);
    public boolean delete(Long CodeDevis);
    public Devis save(Devis devis);
    public Optional<Devis> findById(Long id);
    public List<Devis> getAll();
}
