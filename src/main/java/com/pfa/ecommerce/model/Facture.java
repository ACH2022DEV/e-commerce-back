package com.pfa.ecommerce.model;

import com.pfa.ecommerce.entities.ArticleFactureEntity;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Facture {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer montantTotal;
    private Personne personne;
    private List<ArticleFacture> articles;
}
