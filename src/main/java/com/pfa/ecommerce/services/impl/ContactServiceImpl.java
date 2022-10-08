package com.pfa.ecommerce.services.impl;

import com.pfa.ecommerce.entities.ContactEntity;
import com.pfa.ecommerce.entities.dto.CreateContactDto;
import com.pfa.ecommerce.mappers.ContactMapper;
import com.pfa.ecommerce.model.Contact;
import com.pfa.ecommerce.repository.ContactRepository;
import com.pfa.ecommerce.repository.PersonneRepository;
import com.pfa.ecommerce.services.intf.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContactServiceImpl implements IContactService {
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    PersonneRepository personneRepository;
    public List<Contact> getAll() {
        return ContactMapper.INSTANCE.mapToModels(contactRepository.findAll());
    }
    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id).map(ContactMapper.INSTANCE::mapToModel);
    }
    @Override
    public void save(CreateContactDto createContactDto) {

        createContactDto.getContact().forEach(contact -> {

            ContactEntity contactEntityToSave = new ContactEntity();
            if (createContactDto.getContact() != null) {
                contactEntityToSave.setMessage(contact.getMessage());
                contactEntityToSave.setSujet(contact.getSujet());
                contactEntityToSave.setDestinateur(contact.getDestinateur());
                contactEntityToSave.setDateContact(LocalDateTime.now());

                // il faut que la personne soit présente
                personneRepository.findById(createContactDto.getIdPersonne()).map(per -> {
                    contactEntityToSave.setPersonne(per);
                    return contactEntityToSave;
                });

            contactRepository.save(contactEntityToSave);
           // }
            } });
    }
    public boolean delete(Long id) {

        Optional<ContactEntity> contact = contactRepository.findById(id);
        if (contact.isPresent()) {
            contactRepository.deleteById(id);
        }
        return true;
    }
}
