package com.pfa.ecommerce.mappers;

import com.pfa.ecommerce.entities.PersonneEntity;
import com.pfa.ecommerce.model.Personne;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonneMapper {

    PersonneMapper INSTANCE = Mappers.getMapper(PersonneMapper.class);

    Personne mapToModel(PersonneEntity personne);

    PersonneEntity mapToEntity(Personne personne);

    List<PersonneEntity> mapToEntities(List<Personne> personnes);

    List<Personne> mapToModels(List<PersonneEntity> personnes);
}
