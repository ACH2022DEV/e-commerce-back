package com.pfa.ecommerce.model;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.FactureEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ArticleFacture {
    @Schema(name="id", description = "l'identifiant technique de l'objet ArticleFacture ")
    Long id;
    @Schema(name="facture", description = "l'objet facture ")
    private Facture facture;
    @Schema(name="article", description = " l'objet article ")
    private Article article;
    @Schema(name="dateEdition", description = "le date de creation d'un article ")
    private LocalDateTime dateEdition;
    @Schema(name="quantite", description = "la quantité des articles dans un facture ")
    @Min(1)
    private Long quatite;
    @Schema(name="remise", description = "le remise de tous les articles")
    @Min(1)
    private Float remise;
}
