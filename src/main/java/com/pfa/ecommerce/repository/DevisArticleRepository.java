package com.pfa.ecommerce.repository;

import com.pfa.ecommerce.entities.DevisArticleEntity;
import com.pfa.ecommerce.entities.DevisEntity;
import com.pfa.ecommerce.entities.FactureEntity;
import com.pfa.ecommerce.entities.PanierEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DevisArticleRepository extends JpaRepository<DevisArticleEntity, Long>, JpaSpecificationExecutor<DevisArticleEntity> {

    @Query(value = "select da from DevisArticleEntity da where da.devis.codedevis = :devisId and da.article.codeArticle = :articleId")
    public Optional<DevisArticleEntity> findbyArticleIdandDevisId(Long devisId, Long articleId);

    @Query(value = "select da from DevisArticleEntity da where da.devis.codedevis = :devisId ")
    public List<DevisArticleEntity> findbyDevisId(Long devisId);
    //de moi
    @Query(value = "select da from DevisArticleEntity da where da.article.codeArticle = :articleId ")
    public List<DevisArticleEntity> findbyArticleId(Long articleId);

   /* @Query("select devis from DevisArticleEntity devis where "+ "CONCAT( devis.description,devis.codedevis,devis.personne.id,devis.personne.nom) "+"LIKE CONCAT( '%',:keyword,'%')")
    public Page<DevisArticleEntity> findBySearch(Pageable pageable, String keyword);*/

}
