package com.pfa.ecommerce.repository;

import com.pfa.ecommerce.entities.PersonneEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface PersonneRepository extends JpaRepository <PersonneEntity, Long> {

    Optional<PersonneEntity> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    //Page<PersonneEntity> findByNom(Pageable pageable);

}
