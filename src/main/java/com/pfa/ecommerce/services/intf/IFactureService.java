package com.pfa.ecommerce.services.intf;

import com.pfa.ecommerce.entities.dto.CreateFacture;
import com.pfa.ecommerce.model.Facture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFactureService  {
    public Page<Facture> getAll(Pageable pageable) ;
    public Optional<Facture> findById(Long id);
    public Facture save(CreateFacture facture);
    public Facture update(Facture facture);
    public boolean delete(Long code);

}
