package com.pfa.ecommerce.mappers;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.entities.ImagesEntity;
import com.pfa.ecommerce.model.Article;
import com.pfa.ecommerce.model.Images;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ImagesMapper {
    ImagesMapper INSTANCE = Mappers.getMapper(ImagesMapper.class);

    Images mapToModel(ImagesEntity images);

    ImagesEntity mapToEntity(Images images);

    List<ImagesEntity> mapToEntities(List<Images> listimages);

    List<Images> mapToModels(List<ImagesEntity> listimages);
}
