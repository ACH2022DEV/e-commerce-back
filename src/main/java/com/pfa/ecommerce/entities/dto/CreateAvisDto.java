package com.pfa.ecommerce.entities.dto;

import com.pfa.ecommerce.model.Avis;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAvisDto {
    private Long idPersonne;
    private List<AvisDto> avis;
}
