package com.pfa.ecommerce.repository;

import java.util.Optional;

import com.pfa.ecommerce.entities.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<FactureEntity,Integer>
{
	//Optional<FactureEntity> findById(long code);

}
