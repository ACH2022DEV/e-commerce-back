package com.pfa.ecommerce.model;

import com.pfa.ecommerce.entities.ArticleEntity;
import lombok.*;

import javax.persistence.Column;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Panier {
    private Long id;
    @Column(name = "personneId")
    private Personne personne;
    @Column(name = "articleId")
    private Article article;

    private int quantity;
    private Date date;

}
