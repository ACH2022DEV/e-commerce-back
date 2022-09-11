package com.pfa.ecommerce.services.intf;

import com.pfa.ecommerce.entities.dto.CreateAvisDto;
import com.pfa.ecommerce.model.Avis;

import java.util.List;
import java.util.Optional;

public interface IAvisService {
    public void save(CreateAvisDto avis);
    public boolean delete(Long id);
    public Optional<Avis> findById(Long id);
    public List<Avis> getAll();
}
