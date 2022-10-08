package com.pfa.ecommerce.mappers;

import com.pfa.ecommerce.entities.AvisEntity;
import com.pfa.ecommerce.entities.ContactEntity;
import com.pfa.ecommerce.model.Avis;
import com.pfa.ecommerce.model.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses=PersonneMapper.class)
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);
    Contact mapToModel(ContactEntity contact);
    ContactEntity mapToEntity(Contact contact);
    List<ContactEntity> mapToEntities(List<Contact> contactList);
    List<Contact> mapToModels(List<ContactEntity> contactList);


}
