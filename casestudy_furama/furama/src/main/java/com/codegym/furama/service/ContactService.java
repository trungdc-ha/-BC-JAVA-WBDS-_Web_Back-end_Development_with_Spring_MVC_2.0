package com.codegym.furama.service;

import com.codegym.furama.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContactService {
    void addContact(Contact contact);
    Page<Contact> getAllContact(Pageable pageable);
}
