package com.pfa.ecommerce.model;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.PersonneEntity;
import lombok.*;

import javax.persistence.Column;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Devis {
    private Long codedevis;
    private Integer codeArticle;

    private Integer quantite;
    private Personne personne;
    private List<Article> articles;
}
