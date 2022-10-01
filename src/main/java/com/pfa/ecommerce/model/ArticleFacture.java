package com.pfa.ecommerce.model;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.FactureEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ArticleFacture {
    Long id;
    private Facture facture;
    private Article article;
    private LocalDateTime dateEdition;
    private Long quatite;
    private Float remise;
}
