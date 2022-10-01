package com.pfa.ecommerce.model;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.DevisEntity;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DevisArticle {
    Long id;
    private Devis devis;
    private Article article;
    private LocalDateTime dateEdition;
    private Long quatite;
    private Float remise;
}
