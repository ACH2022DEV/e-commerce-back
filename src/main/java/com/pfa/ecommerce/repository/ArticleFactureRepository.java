package com.pfa.ecommerce.repository;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.ArticleFactureEntity;
import com.pfa.ecommerce.entities.DevisArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArticleFactureRepository extends JpaRepository<ArticleFactureEntity,Long>, JpaSpecificationExecutor<ArticleFactureEntity> {
    @Query(value = "select da from ArticleFactureEntity da where da.facture.id = :factureId and da.article.codeArticle = :articleId")
    public Optional<ArticleFactureEntity> findbyArticleIdandFactureId(Long factureId, Long articleId);

    @Query(value = "select da from ArticleFactureEntity da where da.facture.id = :factureId ")
    public List<ArticleFactureEntity> findbyFactureId(Long factureId);
    @Query(value = "select da from ArticleFactureEntity da where da.article.codeArticle = :articleId")
    public List<ArticleFactureEntity> findbyArticleId( Long articleId);
}
