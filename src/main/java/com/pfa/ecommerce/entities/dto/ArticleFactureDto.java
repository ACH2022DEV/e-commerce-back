package com.pfa.ecommerce.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleFactureDto   {
    private Long codeArticle;
    private Long quatite;
    private Float remise;
}
