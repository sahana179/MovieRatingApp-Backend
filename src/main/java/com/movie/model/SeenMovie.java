package com.movie.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "seen_movie")
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class SeenMovie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "movie_id")
	private String movieId;

	@Column(name = "user_id")
	private long userId;

	@Column(name = "date")
	private Timestamp date;

	
	public SeenMovie() {
		super();
		

	}

	public SeenMovie(String movieId, long userId, Timestamp date) {
		super();
		this.movieId = movieId;
		this.userId = userId;
		this.date = date;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}
