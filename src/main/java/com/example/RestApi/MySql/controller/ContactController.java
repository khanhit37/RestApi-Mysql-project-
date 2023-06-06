package com.example.RestApi.MySql.controller;


import com.example.RestApi.MySql.model.Contact;
import com.example.RestApi.MySql.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact")
@AllArgsConstructor
public class ContactController {

    @Autowired
    private ContactService contactService;

    // creat contact rest api
    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact){
        Contact saveContact = contactService.creatContact(contact);
        return new ResponseEntity<>(saveContact, HttpStatus.CREATED);
    }

    //get contact by id
    @GetMapping("{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") Long id){
        Contact contact = contactService.getContactById(id);
        return new ResponseEntity<>(contact,HttpStatus.OK);
    }

    //Get All contact
    @GetMapping("")
            public ResponseEntity<List<Contact>> getAllContact() {

        List<Contact> contacts = contactService.getAllContact();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    //Update contact
//    @PutMapping("{id}")
//    public ResponseEntity<Contact> updateContact(PathVariable("id") Long id, @RequestBody Contact contact){
//        contact.setId(id);
//        Contact updateContact = contactService.updateContact(contact);
//        return new ResponseEntity<>(updateContact,HttpStatus.OK);
//
//    }
    @PutMapping("{id}")
    public Contact updateContact(@PathVariable("id") Long id, @RequestBody Contact contact){
        contact.setId(id);
        return contact;
    }



    //Delete contact
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("id") Long id){
        contactService.deleteContactById(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }



}
