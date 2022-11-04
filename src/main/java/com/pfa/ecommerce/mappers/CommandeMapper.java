package com.pfa.ecommerce.mappers;

import com.pfa.ecommerce.entities.CommandeEntity;
import com.pfa.ecommerce.model.Commande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses={PersonneMapper.class, ArticleMapper.class})

public interface CommandeMapper {
    CommandeMapper INSTANCE = Mappers.getMapper(CommandeMapper.class);
    Commande mapToModel(CommandeEntity commande);
    CommandeEntity mapToEntity(Commande commande);
    List<CommandeEntity> mapToEntities(List<Commande> commandeList);
    List<Commande> mapToModels(List<CommandeEntity> commandeList);

}
