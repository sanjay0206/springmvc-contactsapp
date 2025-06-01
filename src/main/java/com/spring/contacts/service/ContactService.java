package com.spring.contacts.service;


import com.spring.contacts.model.Contact;
import com.spring.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Optional<Contact> findById(int id) {
        return contactRepository.findById(id);
    }

    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    public void updateContact(int id, Contact contact) {
        Contact updatedContact = contactRepository.findById(id).orElse(null);

        if (updatedContact == null) {
            throw new IllegalStateException("Contact with id: " + id + " not found");
        }

        updatedContact.setName(contact.getName());
        updatedContact.setEmail(contact.getEmail());
        updatedContact.setCountry(contact.getCountry());
        contactRepository.save(updatedContact);
    }

    public void deleteById(int id) {
        contactRepository.deleteById(id);
    }
}
