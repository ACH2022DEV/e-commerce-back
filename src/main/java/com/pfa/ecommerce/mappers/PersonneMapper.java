package com.pfa.ecommerce.mappers;

import com.pfa.ecommerce.entities.PersonneEntity;
import com.pfa.ecommerce.model.Personne;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(uses = {PanierMapper.class, AvisMapper.class,ImagesMapper.class})
public interface PersonneMapper {

    PersonneMapper INSTANCE = Mappers.getMapper(PersonneMapper.class);


    Personne mapToModel(PersonneEntity personne);


    PersonneEntity mapToEntity(Personne personne);


    List<PersonneEntity> mapToEntities(List<Personne> personnes);


    List<Personne> mapToModels(List<PersonneEntity> personnes);
    // nouveau ligne
   /* Page<Personne> mapToModels(Page<PersonneEntity> personneEntityPage);
    Page<PersonneEntity> mapToEntities(Page<Personne> personneEntityPage);*/


}
