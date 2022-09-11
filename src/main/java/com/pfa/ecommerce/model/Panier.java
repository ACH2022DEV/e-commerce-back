package com.pfa.ecommerce.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Panier {
    private Long id;
    //@Column(name = "personneId")
    private Personne personne;
    // @Column(name = "articleId")
    private Article article;

    private int quantity;

    private LocalDateTime date;

}
