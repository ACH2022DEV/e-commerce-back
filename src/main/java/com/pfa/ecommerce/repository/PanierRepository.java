package com.pfa.ecommerce.repository;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.PanierEntity;
import com.pfa.ecommerce.entities.PersonneEntity;
import com.pfa.ecommerce.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierRepository extends JpaRepository<PanierEntity,Long> {
    //public List<PanierEntity> findByClient(PersonneEntity client);
    //public PanierEntity findByClientAndArticle(PersonneEntity client, ArticleEntity article);
}
