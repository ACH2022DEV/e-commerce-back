package com.pfa.ecommerce.repository;

import com.pfa.ecommerce.entities.DevisArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevisArticleRepository extends JpaRepository<DevisArticleEntity, Long> {

    //findbyArticleIdandDevisId
}
