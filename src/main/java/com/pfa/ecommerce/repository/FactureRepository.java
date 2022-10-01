package com.pfa.ecommerce.repository;

import com.pfa.ecommerce.entities.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FactureRepository extends JpaRepository<FactureEntity,Long> , JpaSpecificationExecutor<FactureEntity>
{
	//Optional<FactureEntity> findById(long code);

}
