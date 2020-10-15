package com.dsurchin.movielibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsurchin.movielibrary.dao.MovieDAO;
import com.dsurchin.movielibrary.entity.Movie;

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

}
