package com.pfa.ecommerce.repository;


import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.DetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface DetailsRepository extends JpaRepository<DetailsEntity,Integer> , JpaSpecificationExecutor<DetailsEntity> {

}
