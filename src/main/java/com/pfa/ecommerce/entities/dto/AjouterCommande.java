package com.pfa.ecommerce.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AjouterCommande {
    private Long idPersonne;
    private String tel;
    private String adress;
    private String CodePostal;
    private LocalDateTime dateCommande;
    private String dateLivraison;
    private Integer montantTotal;
    private Integer quantity;
    private String Lepayment;
    private String ville;
    private List<CommandezDto> commande;
}
