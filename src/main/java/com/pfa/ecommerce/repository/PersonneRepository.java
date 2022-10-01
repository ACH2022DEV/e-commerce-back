package com.pfa.ecommerce.repository;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.PanierEntity;
import com.pfa.ecommerce.entities.PersonneEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface PersonneRepository extends JpaRepository <PersonneEntity, Long>, JpaSpecificationExecutor<PersonneEntity> {

    Optional<PersonneEntity> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    //Page<PersonneEntity> findByNom(Pageable pageable);
   @Query("select per from PersonneEntity per where "+ "CONCAT(per.id,per.nom,per.prenom,per.adress,per.tel) "+"LIKE CONCAT( '%',:keyword,'%')")
    public Page<PersonneEntity> findBySearch(Pageable pageable, String keyword);

}
