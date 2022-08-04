package com.pfa.ecommerce.repository;

import java.util.Optional;

import com.pfa.ecommerce.entities.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {


    //Optional<ArticleEntity> findByCodeArticle(Long codeArticle);

}
