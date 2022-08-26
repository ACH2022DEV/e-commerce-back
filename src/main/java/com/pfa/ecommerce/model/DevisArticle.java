package com.pfa.ecommerce.model;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.DevisEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DevisArticle {
    Long id;
    private Devis devis;
    private Article article;
    private Long quatite;
    private Float remise;
}
