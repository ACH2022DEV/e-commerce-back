package com.pfa.ecommerce.services.intf;

import com.pfa.ecommerce.entities.dto.CreateFacture;
import com.pfa.ecommerce.model.Facture;

import java.util.List;
import java.util.Optional;

public interface IFactureService  {
    public List<Facture> getAll();
    public Optional<Facture> findById(Long id);
    public Facture save(CreateFacture facture);
    public Facture update(Facture facture);
    public boolean delete(Long code);

}
