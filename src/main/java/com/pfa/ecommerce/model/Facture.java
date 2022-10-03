package com.pfa.ecommerce.model;

import com.pfa.ecommerce.entities.ArticleFactureEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Facture {
    private static final long serialVersionUID = 1L;
    @Schema(name="id", description = "l'identifiant technique de l'objet facture ")
    private Long id;
    @Schema(name="montantTotal", description = "le montant total de cette facture  ")
    @Min(1)
    private Integer montantTotal;
    @Schema(name="personne", description = "l'objet personne de cette facture ")
    private Personne personne;
    @Schema(name="articles", description = " liste de  articles incluts de cette facture")
    private List<ArticleFacture> articles;
}
