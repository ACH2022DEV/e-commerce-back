package com.pfa.ecommerce.mappers;

import com.pfa.ecommerce.entities.DevisEntity;
import com.pfa.ecommerce.entities.PersonneEntity;
import com.pfa.ecommerce.model.Devis;
import com.pfa.ecommerce.model.Personne;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DevisMapper {
    DevisMapper INSTANCE = Mappers.getMapper(DevisMapper.class);

    Devis mapToModel(DevisEntity devis);

    DevisEntity mapToEntity(Devis devis);

    List<DevisEntity> mapToEntities(List<Devis> devisList);

    List<Devis> mapToModels(List<DevisEntity> devisList);
}
