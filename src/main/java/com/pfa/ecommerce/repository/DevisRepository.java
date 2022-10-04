package com.pfa.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.DevisEntity;
import com.pfa.ecommerce.entities.FactureEntity;
import com.pfa.ecommerce.entities.PanierEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


public interface DevisRepository extends JpaRepository<DevisEntity,Long>, JpaSpecificationExecutor<DevisEntity>
{
	//Optional<DevisEntity> findById(long CodeDevis);
    @Query(value = "select dev from DevisEntity dev where dev.personne.id = :idPersonne ")
    public List<DevisEntity> findbyPersonneId(Long idPersonne);
   /* @Query("select devis from DevisEntity devis where "+ "CONCAT( devis.description,devis.codedevis,devis.personne.id,devis.personne.nom) "+"LIKE CONCAT( '%',:keyword,'%')")
    public Page<DevisEntity> findBySearch(Pageable pageable, String keyword);*/

}
