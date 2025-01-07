package com.adrianj.springsec12.repository;

import com.adrianj.springsec12.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, String> {
	
	
}
