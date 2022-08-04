package com.pfa.ecommerce.repository;

import java.util.Optional;

import com.pfa.ecommerce.entities.DevisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevisRepository extends JpaRepository<DevisEntity,Integer>
{
	//Optional<DevisEntity> findById(long CodeDevis);

}
