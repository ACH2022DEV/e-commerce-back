package com.pfa.ecommerce.model;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.DevisArticleEntity;
import com.pfa.ecommerce.entities.PersonneEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Devis {
    @Schema(name="codedevis", description = "l'identifiant technique de l'objet devis ")

    private Long codedevis;
    @Schema(name="personne", description = "l'objet personne de cette devis  ")

    private Personne personne;
    @Schema(name="articles", description = "la liste des articles dans un devis  ")

    private List<DevisArticle> articles;

}
