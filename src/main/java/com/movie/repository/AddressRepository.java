package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	
}
