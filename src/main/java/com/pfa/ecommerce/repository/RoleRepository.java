package com.pfa.ecommerce.repository;

import com.pfa.ecommerce.entities.ERole;
import com.pfa.ecommerce.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(ERole name);
}

