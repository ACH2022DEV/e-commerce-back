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
    @Mapping(source = "personne", target = "personne", ignore = true)//par moi

    Commande mapToModel(CommandeEntity commande);
    @Mapping(source = "personne", target = "personne", ignore = true)//par moi

    CommandeEntity mapToEntity(Commande commande);
   //@Mapping(source = "personne", target = "personne", ignore = true)//par moi

    List<CommandeEntity> mapToEntities(List<Commande> commandeList);
 @Mapping(source = "personne", target = "personne", ignore = true)//par moi

    List<Commande> mapToModels(List<CommandeEntity> commandeList);

}
