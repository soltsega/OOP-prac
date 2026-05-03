package com.oopprac.contactmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    private final List<Contact> contacts = new ArrayList<>();

    @GetMapping
    public List<Contact> getContacts() {
        return Collections.unmodifiableList(contacts);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contact addContact(@RequestBody Contact contact) {
        validate(contact);
        Contact savedContact = new Contact(
                contact.getName().trim(),
                contact.getEmail().trim(),
                contact.getPhone().trim());
        contacts.add(savedContact);
        return savedContact;
    }

    private void validate(Contact contact) {
        if (contact == null || isBlank(contact.getName()) || isBlank(contact.getEmail()) || isBlank(contact.getPhone())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "All fields are required.");
        }
        if (!contact.getEmail().contains("@") || !contact.getEmail().contains(".")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please enter a valid email address.");
        }
        if (!contact.getPhone().matches("\\d{10}")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Phone must be exactly 10 digits.");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
