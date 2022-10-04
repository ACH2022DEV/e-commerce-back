package com.pfa.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.AvisEntity;
import com.pfa.ecommerce.entities.ImagesEntity;
import com.pfa.ecommerce.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import static org.hibernate.hql.internal.antlr.HqlTokenTypes.CONCAT;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> , JpaSpecificationExecutor<ArticleEntity> {


    //Optional<ArticleEntity> findByCodeArticle(Long codeArticle);


    @Query("select art from ArticleEntity art where "+ "CONCAT( art.description,art.codeArticle,art.paysOrigine,art.prix,art.tva,art.remise,art.quantite) "+"LIKE CONCAT( '%',:keyword,'%')")
    public Page<ArticleEntity> findBySearch(Pageable pageable,String keyword);

  /*  @Query(value = "select i from ArticleEntity i  where  i.images.id in (articleId)")
    public List<ArticleEntity> findbyArticleId1(Long articleId);*/
}
