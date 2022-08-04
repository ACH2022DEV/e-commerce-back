package com.pfa.ecommerce.model;

import lombok.*;

import javax.persistence.Column;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Details {
    private Long code;

    private Integer quantite;

    private Integer codeArticle;
}
