package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	List<Movie> findByTitleContaining(String title);
}
