package com.pfa.ecommerce.mappers;

import com.pfa.ecommerce.entities.FactureEntity;
import com.pfa.ecommerce.entities.PersonneEntity;
import com.pfa.ecommerce.model.Facture;
import com.pfa.ecommerce.model.Personne;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface FactureMapper {
    FactureMapper INSTANCE = Mappers.getMapper(FactureMapper.class);

    Facture mapToModel(FactureEntity facture);

    FactureEntity mapToEntity(Facture facture);

    List<FactureEntity> mapToEntities(List<Facture> factures);

    List<Facture> mapToModels(List<FactureEntity> factures);
}
