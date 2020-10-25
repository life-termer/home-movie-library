package com.dsurchin.movielibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsurchin.movielibrary.dao.MovieDAO;
import com.dsurchin.movielibrary.entity.Genres;
import com.dsurchin.movielibrary.entity.Movie;
import com.dsurchin.movielibrary.entity.Review;

@Service		//Service implementation
public class MovieServiceImpl implements MovieService {

	// inject MovieDAO
	@Autowired
	private MovieDAO movieDAO;
	
	// delegate calls to DAO, define transactions at Service layer
	@Transactional		// Automatically begin and end a transaction for Hibernate code
	@Override
	public List<Movie> getMovies() {
		return movieDAO.getMovies();
	}
	
	@Transactional
	@Override
	public void saveMovie(Movie movie) {
		movieDAO.saveMovie(movie);
	}

	@Transactional
	@Override
	public Movie getMovie(int id) {
		return movieDAO.getMovie(id);
	}

	@Transactional
	@Override
	public void deleteMovie(int id) {
		movieDAO.deleteMovie(id);
	}

	@Transactional
	@Override
	public List<Genres> getGenres() {
		return movieDAO.getGenres();
	}

	@Transactional
	@Override
	public List<Review> getReviews(int id) {
		return movieDAO.getReviews(id);
	}

	@Transactional
	@Override
	public void saveReview(Review review) {
		movieDAO.saveReview(review);
	}
	
	

}
