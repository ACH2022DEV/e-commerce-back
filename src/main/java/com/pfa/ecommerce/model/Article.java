package com.pfa.ecommerce.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Article {

    private Long codeArticle;
    private String description;
    private String photo;
    private String paysOrigine;
    private Integer prix;
    private Integer tva;
    private Integer remise;
    private Integer quantite;
}
