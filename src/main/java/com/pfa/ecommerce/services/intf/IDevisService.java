package com.pfa.ecommerce.services.intf;

import com.pfa.ecommerce.model.Devis;

import java.util.List;
import java.util.Optional;

public interface IDevisService {
    public Devis update(Integer CodeDevis, Devis devis);
    public boolean delete(Integer CodeDevis);
    public Devis save(Devis devis);
    public Optional<Devis> findById(Integer id);
    public List<Devis> getAll();
}
