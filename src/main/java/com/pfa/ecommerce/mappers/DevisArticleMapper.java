package com.pfa.ecommerce.mappers;

import com.pfa.ecommerce.entities.DevisArticleEntity;
import com.pfa.ecommerce.model.DevisArticle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {DevisMapper.class, ArticleMapper.class})
public interface DevisArticleMapper {
    DevisArticleMapper INSTANCE = Mappers.getMapper(DevisArticleMapper.class);
    @Mapping(source="devis", target = "devis", ignore = true)
    DevisArticle mapToModel(DevisArticleEntity devis);
    @Mapping(source="devis", target = "devis", ignore = true)
    DevisArticleEntity mapToEntity(DevisArticle devis);

    List<DevisArticleEntity> mapToEntities(List<DevisArticle> devisList);

    @Mapping(source="devis", target = "devis", ignore = true)
    List<DevisArticle> mapToModels(List<DevisArticleEntity> devisList);
}
