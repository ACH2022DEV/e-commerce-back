package com.pfa.ecommerce.services.intf;

import com.pfa.ecommerce.entities.dto.AjouterCommande;
import com.pfa.ecommerce.model.Commande;

import java.util.List;
import java.util.Optional;

public interface ICommandeService {
    public boolean delete(Long id);
    public void save(AjouterCommande ajouterCommande);
    public Optional<Commande> findById(Long id);
    public List<Commande> getAll();
}
