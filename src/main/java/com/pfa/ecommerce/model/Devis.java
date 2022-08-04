package com.pfa.ecommerce.model;

import lombok.*;

import javax.persistence.Column;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Devis {
    private Long codedevis;
    private Integer codeArticle;

    private Integer quantite;
}
