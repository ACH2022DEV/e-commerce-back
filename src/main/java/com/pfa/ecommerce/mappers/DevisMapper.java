package com.pfa.ecommerce.mappers;

import com.pfa.ecommerce.entities.DevisEntity;
import com.pfa.ecommerce.entities.PersonneEntity;
import com.pfa.ecommerce.model.Devis;
import com.pfa.ecommerce.model.Personne;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {DevisArticleMapper.class, PersonneMapper.class})
public interface DevisMapper {
    DevisMapper INSTANCE = Mappers.getMapper(DevisMapper.class);

    @Mapping(target = "personne.paniers", source = "personne.paniers", ignore = true)
    @Mapping(target = "personne.avis", source = "personne.avis", ignore = true)
    Devis mapToModel(DevisEntity devis);

    DevisEntity mapToEntity(Devis devis);

    List<DevisEntity> mapToEntities(List<Devis> devisList);
    @Mapping(source="personne", target = "personne", ignore = true)//par moi
    @Mapping(target = "personne.avis", source = "personne.avis", ignore = true)

    List<Devis> mapToModels(List<DevisEntity> devisList);
}
