package com.pfa.ecommerce.services.intf;

import com.pfa.ecommerce.model.Facture;

import java.util.List;
import java.util.Optional;

public interface IFactureService  {
    public List<Facture> getAll();
    public Optional<Facture> findById(Integer id);
    public Facture save(Facture facture);
    public Facture update(Integer Id,Facture facture);
    public Boolean delete(Integer code);

}
