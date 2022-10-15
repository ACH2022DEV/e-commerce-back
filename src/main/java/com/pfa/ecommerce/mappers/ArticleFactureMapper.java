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

    @Mapping(source = "facture", target = "facture", ignore = true)//par moi
    @Mapping(source = "article.avis", target = "article.avis", ignore = true)
//par moi
    ArticleFacture mapToModel(ArticleFactureEntity facture);

    @Mapping(source="facture", target = "facture", ignore = true)
    @Mapping(source = "article.avis", target = "article.avis", ignore = true)
//par moi

    ArticleFactureEntity mapToEntity(ArticleFacture facture);

    List<ArticleFactureEntity> mapToEntities(List<ArticleFacture> factureList);

    @Mapping(source = "facture", target = "facture", ignore = true) //par moi
    @Mapping(source = "article.avis", target = "article.avis", ignore = true)
//par moi
    List<ArticleFacture> mapToModels(List<ArticleFactureEntity> factureList);
}
