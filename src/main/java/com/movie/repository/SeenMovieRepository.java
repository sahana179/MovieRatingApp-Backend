package com.movie.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movie.model.MovieGroubBy;
import com.movie.model.SeenMovie;

public interface SeenMovieRepository extends JpaRepository<SeenMovie, Long> {
	List<SeenMovie> findAllByOrderByDateDesc();
	List<SeenMovie> findByUserIdOrderByDateDesc(long userid);
	Optional<SeenMovie> findFirstByUserIdOrderByDateDesc(long userid);
	@Query("SELECT c.movieId as movieId , COUNT(c.movieId) as totalCount "
			  + "FROM SeenMovie AS c GROUP BY movieId ORDER BY totalCount DESC")
	List<MovieGroubBy> groupByMovie();
}
