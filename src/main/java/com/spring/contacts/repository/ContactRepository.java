package com.spring.contacts.repository;

import com.spring.contacts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
