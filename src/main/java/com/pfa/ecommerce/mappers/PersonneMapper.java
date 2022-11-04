package com.pfa.ecommerce.mappers;

import com.pfa.ecommerce.entities.PersonneEntity;
import com.pfa.ecommerce.model.Personne;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(uses = {PanierMapper.class, AvisMapper.class,ImagesMapper.class, CommandeMapper.class})
public interface PersonneMapper {

    PersonneMapper INSTANCE = Mappers.getMapper(PersonneMapper.class);
    //@Mapping(source = "commandes", target = "commandes", ignore = true)//par moi
  //  @Mapping(source = "avis", target = "avis", ignore = true)//par moi
    Personne mapToModel(PersonneEntity personne);
  //  @Mapping(source = "commandes", target = "commandes", ignore = true)//par moi
  //@Mapping(source = "avis", target = "avis", ignore = true)//par moi

    PersonneEntity mapToEntity(Personne personne);
   // @Mapping(source = "commandes", target = "commandes", ignore = true)//par moi
  // @Mapping(source = "avis", target = "avis", ignore = true)//par moi

    List<PersonneEntity> mapToEntities(List<Personne> personnes);
    //@Mapping(source = "commandes", target = "commandes", ignore = true)//par moi
    //@Mapping(source = "avis", target = "avis", ignore = true)//par moi

    List<Personne> mapToModels(List<PersonneEntity> personnes);
    // nouveau ligne
   /* Page<Personne> mapToModels(Page<PersonneEntity> personneEntityPage);
    Page<PersonneEntity> mapToEntities(Page<Personne> personneEntityPage);*/


}
