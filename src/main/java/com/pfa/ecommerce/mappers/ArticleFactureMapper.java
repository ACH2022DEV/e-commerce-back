package com.pfa.ecommerce.mappers;

import com.pfa.ecommerce.entities.ArticleFactureEntity;
import com.pfa.ecommerce.model.ArticleFacture;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {FactureMapper.class, ArticleMapper.class})
public interface ArticleFactureMapper {
    ArticleFactureMapper INSTANCE = Mappers.getMapper(ArticleFactureMapper.class);

    ArticleFacture mapToModel(ArticleFactureEntity facture);
//    @Mapping(source="facture", target = "facture", ignore = true)

    ArticleFactureEntity mapToEntity(ArticleFacture facture);

    List<ArticleFactureEntity> mapToEntities(List<ArticleFacture> factureList);

    List<ArticleFacture> mapToModels(List<ArticleFactureEntity> factureList);
}
