package com.pfa.ecommerce.entities.dto;


import com.pfa.ecommerce.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DevisArticlDto  {
    private Long codeArticle;
    private Long quatite;
    private Float remise;
}
