package com.pfa.ecommerce.services.intf;

import com.pfa.ecommerce.entities.dto.CreateFacture;
import com.pfa.ecommerce.entities.dto.CreatePanier;
import com.pfa.ecommerce.model.Facture;
import com.pfa.ecommerce.model.Panier;

import java.util.List;
import java.util.Optional;

public interface IPanierService {
    public List<Panier> getAll();
    public Optional<Panier> findById(Long id);
    public void save(CreatePanier createPanier);
    public Panier update(Panier panier);
    public Boolean delete(Long id);
}
