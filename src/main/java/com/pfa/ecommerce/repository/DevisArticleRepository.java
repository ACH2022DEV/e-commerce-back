package com.pfa.ecommerce.repository;

import com.pfa.ecommerce.entities.DevisArticleEntity;
import com.pfa.ecommerce.entities.PanierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DevisArticleRepository extends JpaRepository<DevisArticleEntity, Long> {

    @Query(value = "select da from DevisArticleEntity da where da.devis.codedevis = :devisId and da.article.codeArticle = :articleId")
    public Optional<DevisArticleEntity> findbyArticleIdandDevisId(Long devisId, Long articleId);

    @Query(value = "select da from DevisArticleEntity da where da.devis.codedevis = :devisId ")
    public List<DevisArticleEntity> findbyDevisId(Long devisId);
    //de moi

}
