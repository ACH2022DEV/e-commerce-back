package com.pfa.ecommerce.mappers;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.PanierEntity;
import com.pfa.ecommerce.model.Article;
import com.pfa.ecommerce.model.Panier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(uses = {PersonneMapper.class, ArticleMapper.class})
public interface PanierMapper {
    PanierMapper INSTANCE = Mappers.getMapper(PanierMapper.class);

    @Mapping(source = "personne", target = "personne", ignore = true)//par moi
    @Mapping(source = "article", target = "article", ignore = true)//par moi

    Panier mapToModel(PanierEntity panier);

   @Mapping(source = "personne", target = "personne", ignore = true)//par moi
   @Mapping(source = "article", target = "article", ignore = true)//par moi

    PanierEntity mapToEntity(Panier panier);

    List<PanierEntity> mapToEntities(List<Panier> listpanier);

   @Mapping(source = "personne", target = "personne", ignore = true)//par moi
    @Mapping(source = "article", target = "article", ignore = true)//par moi

    List<Panier> mapToModels(List<PanierEntity> listpanier);
}
