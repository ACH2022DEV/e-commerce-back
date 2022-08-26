package com.pfa.ecommerce.entities.dto;


import com.pfa.ecommerce.model.Personne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateDevis {

    private Long idPersonne;
    private List<DevisArticlDto> articles;
}