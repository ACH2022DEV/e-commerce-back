package com.pfa.ecommerce.repository;


import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.AvisEntity;
import com.pfa.ecommerce.entities.FactureEntity;
import com.pfa.ecommerce.entities.PanierEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AvisRepository extends JpaRepository<AvisEntity, Long> , JpaSpecificationExecutor<AvisEntity> {


    @Query(value = "select avis from AvisEntity avis where avis.personne.id = :personneId ")
    public List<AvisEntity> findbyPersonneId(Long personneId);
    @Query(value = "select avis from AvisEntity avis where avis.article.codeArticle = :ArticleId ")
    public List<AvisEntity> findbyArticleId(Long ArticleId);

    @Query("select avis from AvisEntity avis where avis.etoile =  :keyword")
    public Page<AvisEntity> findBySearch(Pageable pageable, Integer keyword);

}
