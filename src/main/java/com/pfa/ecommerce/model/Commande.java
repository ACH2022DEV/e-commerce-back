package com.pfa.ecommerce.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Commande {
    @Schema(name="id", description = "l'identifiant technique de l'objet commande ")
    private Long id;
    @Schema(name="tel", description = "le Numero telephone de  personne ")
    @NotBlank
    @Size(min = 0, max = 8)
    private String tel;
    @Schema(name="adress", description = "l'adress de  personne ")
    @NotBlank
    @Size(min = 0, max = 25)
    private String adress;
    @Schema(name="personne", description = " l'objet personne de cette commande  ")
    private Personne personne;
    @Schema(name="CodePostal", description = "le CodePostal de personne ")
    private String CodePostal;
    @Schema(name="dateContact", description = "le date de création de cette commande  ")
    private LocalDateTime dateCommande;
    @Schema(name="dateLivraison", description = "le date de livraison de cette commande  ")
    private String dateLivraison;
    @Schema(name="article", description = "l'objet article de cette commande")
    private Article  article;
    @Schema(name="montantTotal", description = "le montant total de cette facture  ")
    @Min(1)
    private Integer montantTotal;
    @Schema(name="montantTotal", description = "le montant total de cette facture  ")
    private String Lepayment;
    @Schema(name="ville", description = "le ville de client ")
    @NotBlank
    @Size(min = 1, max = 15)
    private String ville;
}
