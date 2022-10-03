package com.pfa.ecommerce.model;

import com.pfa.ecommerce.entities.AvisEntity;
import com.pfa.ecommerce.entities.PanierEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Article {
    @Schema(name="codeArticle", description = "l'identifiant technique de l'objet Article ")
    private Long codeArticle;

    @Schema(name="description", description = "le nom de cette article ")
    @NotBlank
    @Size(min = 0, max = 25)
    private String description;
    @Schema(name="paysOrigine", description = "le nom de pays qui crée  cette article ")
    @NotBlank
    @Size(min = 0, max = 25)
    private String paysOrigine;
    @Schema(name="prix", description = "le prix de cette article ")
    @Min(1)
    private Integer prix;
    @Schema(name="tva", description = "le tva de cette article ")
    @Min(1)
    private Integer tva;
    @Schema(name="remise", description = "le remise pour cette article ")
    @Min(2)
    private Integer remise;
    @Schema(name="quantite", description = "la quantité des articles  ")
    @Min(1)
    private Integer quantite;
    @Schema(name="images", description = "la liste des images de cette articles ")
    private List<Image> images;
    @Schema(name="avis", description = "la liste des avis de cette articles ")
    private List<Avis> avis;
    //la nouvelle modification
    /*private List<DevisArticle> devis;
    private List<ArticleFacture> facture;
    private List<Panier> panier;*/


}



















