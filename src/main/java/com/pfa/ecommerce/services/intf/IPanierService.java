package com.pfa.ecommerce.services.intf;

import com.pfa.ecommerce.entities.dto.CreateUpdatePanierDto;
import com.pfa.ecommerce.model.Article;
import com.pfa.ecommerce.model.Panier;

import java.util.List;
import java.util.Optional;

public interface IPanierService {
    public List<Panier> getAll();

    public Optional<Panier> findById(Long id);

    public void save(CreateUpdatePanierDto panier);

    //public Panier update(Panier panier);
    public boolean delete(Long id);
}
