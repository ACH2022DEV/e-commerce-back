package com.pfa.ecommerce.repository;

import com.pfa.ecommerce.entities.CommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommandeRepository extends JpaRepository<CommandeEntity, Long>, JpaSpecificationExecutor<CommandeEntity> {
}
