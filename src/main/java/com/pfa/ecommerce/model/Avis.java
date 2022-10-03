package com.pfa.ecommerce.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Avis {
    @Schema(name="id", description = "l'identifiant technique de l'objet avis ")
    private Long id;
    @Schema(name="message", description = "le commentaire d'un utilisateur ")
    @NotBlank
    @Size(min = 0, max = 50)
    private String message;
    @Schema(name="etoile", description = "le nombre d'étoiles d'un utilisateur  ")
    @Min(1)
    private Integer etoile;
    @Schema(name="personne", description = " l'objet personne de cette avis  ")
    private Personne personne;
    @Schema(name="article", description = " l'objet article de cette avis ")
    private Article article;
    @Schema(name="dateAvis", description = "le date de création de cette avis  ")
    private LocalDateTime dateAvis;
}
