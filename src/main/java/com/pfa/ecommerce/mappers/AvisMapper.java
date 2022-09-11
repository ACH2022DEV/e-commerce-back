package com.pfa.ecommerce.mappers;

import com.pfa.ecommerce.entities.AvisEntity;
import com.pfa.ecommerce.entities.DevisArticleEntity;
import com.pfa.ecommerce.model.Avis;
import com.pfa.ecommerce.model.DevisArticle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {ArticleMapper.class,PersonneMapper.class})
public interface AvisMapper {
    AvisMapper INSTANCE = Mappers.getMapper(AvisMapper.class);
    @Mapping(source = "article", target = "article", ignore = true)//par moi
    @Mapping(source = "personne.paniers", target = "personne.paniers", ignore = true)//par moi
    @Mapping(source = "personne.role", target = "personne.role", ignore = true)//par moi

    Avis mapToModel(AvisEntity avis);
    @Mapping(source = "personne.paniers", target = "personne.paniers", ignore = true)//par moi
    @Mapping(source = "article", target = "article", ignore = true)//par moi
    @Mapping(source = "personne.role", target = "personne.role", ignore = true)//par moi




    AvisEntity mapToEntity(Avis avis);
    @Mapping(source = "personne.paniers", target = "personne.paniers", ignore = true)//par moi
    @Mapping(source = "article", target = "article", ignore = true)//par moi
    @Mapping(source = "personne.role", target = "personne.role", ignore = true)//par moi


    List<AvisEntity> mapToEntities(List<Avis> avisList);
    @Mapping(source = "personne.paniers", target = "personne.paniers", ignore = true)//par moi
    @Mapping(source = "article", target = "article", ignore = true)//par moi
    @Mapping(source = "personne.role", target = "personne.role", ignore = true)//par moi





    List<Avis> mapToModels(List<AvisEntity> avisList);
}

