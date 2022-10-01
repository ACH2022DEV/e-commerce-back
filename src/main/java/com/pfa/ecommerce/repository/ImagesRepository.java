package com.pfa.ecommerce.repository;


import com.pfa.ecommerce.entities.ArticleFactureEntity;
import com.pfa.ecommerce.entities.FactureEntity;
import com.pfa.ecommerce.entities.ImagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImagesRepository extends JpaRepository<ImagesEntity,Long> , JpaSpecificationExecutor<ImagesEntity> {
//gg
/*@Query(value = "select i from ImagesEntity i where  in(select p from ArticleEntity p where p.images.id=i.id)")
public List<ImagesEntity> findbyArticleId(Long articleId);*/
@Query(value = "select i from ImagesEntity i where  i.id in (select p from ArticleEntity p where p.codeArticle =:articleId)")
    public List<ImagesEntity> findbyArticleId1(Long articleId);

   /* @Query(value = " delete i  image_article perssemainecompt where image_article.image_id = perssemainecompt.image_id and perssemainecompt.code_article = articleId)")
    public List<ImagesEntity> findbyArticleId(Long articleId);
*/

}
