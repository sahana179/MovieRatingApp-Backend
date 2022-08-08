package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByUsernameContaining(String userName);
	List<User> findByUsername(String userName);
	List<User> findByUsernameAndPassword(String userName,String password);
}
