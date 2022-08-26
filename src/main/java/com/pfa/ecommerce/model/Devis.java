package com.pfa.ecommerce.model;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.DevisArticleEntity;
import com.pfa.ecommerce.entities.PersonneEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Devis {
    private Long codedevis;
    private Personne personne;
    private List<DevisArticle> articles;
}
