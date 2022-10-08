package com.pfa.ecommerce.services.intf;

import com.pfa.ecommerce.entities.dto.CreateContactDto;
import com.pfa.ecommerce.model.Contact;

import java.util.List;
import java.util.Optional;

public interface IContactService {
    public List<Contact> getAll();
    public Optional<Contact> findById(Long id);
    public void save(CreateContactDto createContactDto) ;
    public boolean delete(Long id);




}
