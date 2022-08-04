package com.pfa.ecommerce.repository;

import com.pfa.ecommerce.entities.PersonneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PersonneRepository extends JpaRepository<PersonneEntity, Long> {



}
