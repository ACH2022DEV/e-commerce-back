package com.pfa.ecommerce.mappers;

import com.pfa.ecommerce.entities.DetailsEntity;
import com.pfa.ecommerce.entities.PersonneEntity;
import com.pfa.ecommerce.model.Details;
import com.pfa.ecommerce.model.Personne;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DetailsMapper {
    DetailsMapper INSTANCE = Mappers.getMapper(DetailsMapper.class);

    Details mapToModel(DetailsEntity details);

    DetailsEntity mapToEntity(Details details);

    List<DetailsEntity> mapToEntities(List<Details> detailsList);

    List<Details> mapToModels(List<DetailsEntity> detailsList);
}
