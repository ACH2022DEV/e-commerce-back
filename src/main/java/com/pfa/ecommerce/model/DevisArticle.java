package com.pfa.ecommerce.model;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.DevisEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DevisArticle {
    @Schema(name="id", description = "l'identifiant technique de l'objet devisArticle ")
    Long id;
    @Schema(name="devis", description = "l'objet devis ")

    private Devis devis;
    @Schema(name="article", description = "l'objet article")
    private Article article;
    @Schema(name="dateEdition", description = "le date d'édition de cette objet ")

    private LocalDateTime dateEdition;
    @Schema(name="quatite", description = "la quantité des articles dans un devis  ")
    @Min(1)
    private Long quatite;
    @Schema(name="remise", description = "le remis pour un devis  ")
    @Min(2)
    private Float remise;

}
