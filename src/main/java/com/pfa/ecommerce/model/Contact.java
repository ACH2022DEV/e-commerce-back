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
public class Contact {
    @Schema(name="id", description = "l'identifiant technique de l'objet avis ")
    private Long id;
    @Schema(name="message", description = "le commentaire d'un utilisateur ")
    @NotBlank
    @Size(min = 0, max = 70)
    private String message;
    @Schema(name="destinateur", description = " envoyer vers destinateur ")
    @NotBlank
    @Size(min = 0, max = 15)
    private String destinateur;
    @Schema(name="personne", description = " l'objet personne de cette avis  ")
    private Personne personne;
    @Schema(name="sujet", description = " le sujet de cette message")
    private String sujet;
    @Schema(name="dateContact", description = "le date de création de cette Contact  ")
    private LocalDateTime dateContact;
}
