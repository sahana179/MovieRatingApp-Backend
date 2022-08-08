package com.movie.controller;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.MovieGroubBy;
import com.movie.model.SeenMovie;
import com.movie.repository.SeenMovieRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class SeenMovieController {

	@Autowired
	SeenMovieRepository seenMovieRepository;

	@GetMapping("/seen-movies")
	public ResponseEntity<List<SeenMovie>> getAllmovies(@RequestParam(required = false) Long userId) {
		try {
			List<SeenMovie> movie = new ArrayList<SeenMovie>();

			if (userId == null)
				seenMovieRepository.findAllByOrderByDateDesc().forEach(movie::add);
			else
				seenMovieRepository.findByUserIdOrderByDateDesc(userId).forEach(movie::add);

			if (movie.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(movie, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/seen-movies/{id}")
	public ResponseEntity<SeenMovie> getMovieById(@PathVariable("id") long id) {
		Optional<SeenMovie> movieData = seenMovieRepository.findById(id);

		if (movieData.isPresent()) {
			return new ResponseEntity<>(movieData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/last-seen-by-user/{id}")
	public ResponseEntity<SeenMovie> getMovieByUserId(@PathVariable("id") long userId) {
		Optional<SeenMovie> movieData = seenMovieRepository.findFirstByUserIdOrderByDateDesc(userId);

		if (movieData.isPresent()) {
			return new ResponseEntity<>(movieData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/seen-movies")
	public ResponseEntity<SeenMovie> createMovie(@RequestBody SeenMovie movie) {
		try {
			Timestamp timestamp = new java.sql.Timestamp(new Date().getTime());
			SeenMovie _movie = seenMovieRepository.save(new SeenMovie(movie.getMovieId(),movie.getUserId(), timestamp));
			return new ResponseEntity<>(_movie, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/seen-movies/{id}")
	public ResponseEntity<SeenMovie> updateMovie(@PathVariable("id") long id, @RequestBody SeenMovie movie) {
		Optional<SeenMovie> movieData = seenMovieRepository.findById(id);

		if (movieData.isPresent()) {
			SeenMovie _movie = movieData.get();
			_movie.setMovieId(movie.getMovieId());
			_movie.setUserId(movie.getUserId());
			return new ResponseEntity<>(seenMovieRepository.save(_movie), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/seen-movies/{id}")
	public ResponseEntity<HttpStatus> deleteMovie(@PathVariable("id") long id) {
		try {
			seenMovieRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/seen-movies")
	public ResponseEntity<HttpStatus> deleteAllMovies() {
		try {
			seenMovieRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/most-viewed")
	public ResponseEntity<List<MovieGroubBy>> getAllPopular(@RequestParam(required = false) Long userId) {
		try {
			List<MovieGroubBy> movie = new ArrayList<MovieGroubBy>();

				seenMovieRepository.groupByMovie().forEach(movie::add);
			
			if (movie.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(movie, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
