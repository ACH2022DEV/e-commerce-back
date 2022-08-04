package com.pfa.ecommerce.model;

import lombok.*;

import javax.persistence.Column;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Facture {
    private Long code;

    private Integer montantTotal;

    private Integer id_detail;
}
