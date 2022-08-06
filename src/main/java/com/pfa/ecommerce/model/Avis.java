package com.pfa.ecommerce.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Avis {
    private Long id;
    private String message;
    private Integer etoile;
    private Personne personne;
}
