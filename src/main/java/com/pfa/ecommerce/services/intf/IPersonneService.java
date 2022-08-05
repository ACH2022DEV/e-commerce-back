package com.pfa.ecommerce.services.intf;

import com.pfa.ecommerce.model.Personne;

import java.util.List;
import java.util.Optional;

public interface IPersonneService {

    /**
     * Cette méthode permet de créer une personne
     * @param personne
     * @return
     */
    public Personne save(Personne personne);

    /**
     * Cette fonction peremt de retourner la liste des personnes
     * @return
     */
    public List<Personne> findAll();

    public Optional<Personne> findById(Long id);


    public Personne update(Personne personne);


    public boolean delete(Long id);
}
