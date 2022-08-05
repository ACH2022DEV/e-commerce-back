package com.pfa.ecommerce.repository;

import com.pfa.ecommerce.entities.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<FactureEntity,Long>
{
	//Optional<FactureEntity> findById(long code);

}
