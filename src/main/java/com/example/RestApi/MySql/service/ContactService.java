package com.example.RestApi.MySql.service;

import com.example.RestApi.MySql.model.Contact;

import java.util.List;

public interface ContactService {
    Contact creatContact(Contact contact);

    Contact getContactById(Long id);

    List<Contact> getAllContact();

    Contact updateContact(Contact contact);

    void deleteContactById(Long id);
}
