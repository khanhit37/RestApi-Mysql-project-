package com.example.RestApi.MySql.Repository;

import com.example.RestApi.MySql.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
