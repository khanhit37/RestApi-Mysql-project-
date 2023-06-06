package com.example.RestApi.MySql.service;

import com.example.RestApi.MySql.Repository.ContactRepository;
import com.example.RestApi.MySql.model.Contact;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    @Override
    public Contact creatContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact getContactById(Long id) {
        Optional<Contact> optional = contactRepository.findById(id);
        Contact contact = null;
        if ( optional.isPresent()) {
            contact = optional.get();
        }else{
            throw  new RuntimeException("Employee not found for id ::" + id);
            }
        return contact;

    }

    @Override
    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

    @Override
    public Contact updateContact(Contact contact) {
        return null;
    }

    @Override
    public void deleteContactById(Long id) {
        contactRepository.deleteById(id);

    }
}
