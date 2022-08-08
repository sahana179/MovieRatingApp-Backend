package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	
}
