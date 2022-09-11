package com.pfa.ecommerce.mappers;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.PersonneEntity;
import com.pfa.ecommerce.model.Article;
import com.pfa.ecommerce.model.Personne;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {ImagesMapper.class,DevisArticleMapper.class,ArticleFactureMapper.class,PanierMapper.class, AvisMapper.class})
public interface ArticleMapper {
    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);
    Article mapToModel(ArticleEntity article);

    ArticleEntity mapToEntity(Article article);

    List<ArticleEntity> mapToEntities(List<Article> articles);
    //@Mapping(source="article", target = "article", ignore = true)//par moi

    List<Article> mapToModels(List<ArticleEntity> articles);
}
