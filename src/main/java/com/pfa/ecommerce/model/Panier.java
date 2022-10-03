package com.pfa.ecommerce.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Panier {
    @Schema(name="id", description = "l'identifiant technique de l'objet panier ")
    private Long id;
    @Schema(name="personne", description = "l'objet personne de cette panier")
    private Personne personne;
    @Schema(name="article", description = "l'objet article de cette panier")
    private Article article;
    @Schema(name="quantity", description = "la quantité de cette panier")
    @Min(1)
    private int quantity;
    @Schema(name="date", description = "le date d'insertion d'un article pour cette panier")
    private LocalDateTime date;

}
