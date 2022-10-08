package com.pfa.ecommerce.controller;

import com.pfa.ecommerce.entities.dto.CreateAvisDto;
import com.pfa.ecommerce.entities.dto.CreateContactDto;
import com.pfa.ecommerce.model.Avis;
import com.pfa.ecommerce.model.Contact;
import com.pfa.ecommerce.repository.ContactRepository;
import com.pfa.ecommerce.repository.PersonneRepository;
import com.pfa.ecommerce.services.intf.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;
    @Autowired
    PersonneRepository personneRepository;
    @Autowired
    IContactService iContactService;
    @GetMapping
    public List<Contact> list() {
        return iContactService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Contact> getContact(@PathVariable Long id) {
        return iContactService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        iContactService.delete(id);
    }
    @PostMapping
    public void save(@RequestBody CreateContactDto createContactDto) {
        iContactService.save(createContactDto);
    }




}
