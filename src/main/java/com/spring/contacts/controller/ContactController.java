package com.spring.contacts.controller;


import com.spring.contacts.config.ContactInitializer;
import com.spring.contacts.model.Contact;
import com.spring.contacts.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
    @Autowired
    private ContactService contactService;

    @RequestMapping("/read-contact")
    public String showReadContactPage(Model model) {
        logger.info(model.toString());
        model.addAttribute("contacts", contactService.findAll());
        return "readcontact";
    }

    @RequestMapping("/create-contact")
    public String showCreateContactPage(Model model) {
        model.addAttribute("command", new Contact());
        return "createcontact";
    }

    @RequestMapping(value = "/create-contact", method = RequestMethod.POST)
    public String createContact(@ModelAttribute("contact") Contact contact) {
        contactService.saveContact(contact);
        return "redirect:/read-contact";
    }

    @RequestMapping(value = "/update-contact/{id}")
    public String showUpdateContactPage(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("command", contactService.findById(id).orElse(null));
        return "updatecontact";
    }

    @RequestMapping(value = "/update-contact/{id}", method = RequestMethod.POST)
    public String updateContact(@PathVariable int id, @ModelAttribute("contact") Contact contact) {
        contactService.updateContact(id, contact);
        return "redirect:/read-contact";
    }

    @RequestMapping(value = "/delete-contact/{id}")
    public String deleteContact(@PathVariable int id) {
        contactService.deleteById(id);
        return "redirect:/read-contact";
    }
}