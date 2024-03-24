package com.pfa.ecommerce.services.intf;

import com.pfa.ecommerce.entities.PersonneEntity;
import com.pfa.ecommerce.model.Personne;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    public Page<Personne> getAll(Pageable pageable);

    public Optional<Personne> findById(Long id);


    public Personne update(Personne personne);


    public boolean delete(Long id);
    public Page<Personne> getSearch(Pageable pageable,String keyword);
   //public Page<Personne> Searchcmmandes(Pageable pageable);
   public boolean ifEmailExist(String mail);
    public boolean ifUsernameExist(String username);

    public PersonneEntity getUserByMail(String mail);
}
