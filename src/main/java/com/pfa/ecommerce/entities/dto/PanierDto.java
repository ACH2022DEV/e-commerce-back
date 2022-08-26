package com.pfa.ecommerce.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PanierDto {

    private Long codeArticle;
    private int quantity;
    private Date date;
}
