package com.codegym.furama.service.impl;

import com.codegym.furama.entity.Contact;
import com.codegym.furama.repository.ContactRepository;
import com.codegym.furama.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Override
    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public Page<Contact> getAllContact(Pageable pageable) {
        return contactRepository.findAll(pageable);
    }
}
