package com.spring.contacts.config;

import com.spring.contacts.model.Contact;
import com.spring.contacts.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ContactInitializer {

    private static final Logger logger = LoggerFactory.getLogger(ContactInitializer.class);
    private final ContactRepository contactRepository;

    @Autowired
    public ContactInitializer(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Bean
    public void initializeContacts() {

        // Add initial contacts to the database
        Contact contact1 = new Contact("John Smith", "john.smith@example.com", "United States");
        Contact contact2 = new Contact("Maria Garcia", "garcia.maria@example.com", "Spain");
        Contact contact3 = new Contact("Ahmed Khan", "ahmed.khan@example.com", "Pakistan");
        Contact contact4 = new Contact("Yukiko Tanaka", "yukiko.tanaka@example.com", "Japan");
        Contact contact5 = new Contact("Anna Müller", "anna.mueller@example.com", "Germany");
        Contact contact6 = new Contact("Raj Patel", "raj.patel@example.com", "India");

        List<Contact> contacts = Arrays.asList(contact1, contact2, contact3, contact4, contact5, contact6);
        contacts.forEach(contact -> logger.info("Contact: {}", contact));

        // Save contacts to the database
        contactRepository.saveAll(contacts);
    }
}
