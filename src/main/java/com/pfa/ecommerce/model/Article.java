package com.pfa.ecommerce.model;

import com.pfa.ecommerce.entities.AvisEntity;
import com.pfa.ecommerce.entities.PanierEntity;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Article {

    private Long codeArticle;
    private String description;
    private String paysOrigine;
    private Integer prix;
    private Integer tva;
    private Integer remise;
    private Integer quantite;
    private List<Image> images;
    private List<Avis> avis;
    //la nouvelle modification
    /*private List<DevisArticle> devis;
    private List<ArticleFacture> facture;
    private List<Panier> panier;*/


}



















