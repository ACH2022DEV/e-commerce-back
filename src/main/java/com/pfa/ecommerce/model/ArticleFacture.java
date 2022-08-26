package com.pfa.ecommerce.model;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.FactureEntity;
import lombok.*;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ArticleFacture {
    //@Id
   // @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    //    private FactureEntity facture;
    private Facture facture;
    // private ArticleEntity article;
    private Article article;
    private Long quatite;
    private Float remise;
}
