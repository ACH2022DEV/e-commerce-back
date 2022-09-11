package com.pfa.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import com.pfa.ecommerce.entities.DevisEntity;
import com.pfa.ecommerce.entities.PanierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DevisRepository extends JpaRepository<DevisEntity,Long>
{
	//Optional<DevisEntity> findById(long CodeDevis);
    @Query(value = "select dev from DevisEntity dev where dev.personne.id = :idPersonne ")
    public List<DevisEntity> findbyPersonneId(Long idPersonne);

}
