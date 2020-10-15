package com.dsurchin.movielibrary.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dsurchin.movielibrary.entity.Movie;

public class MovieDAOImpl implements MovieDAO {
	
	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Movie> getMovies() {
		return null;
	}

	@Override
	public void saveMovie(Movie movie) {
	}

	@Override
	public Movie getMovie(int id) {
		return null;
	}

	@Override
	public void deleteMovie(int id) {
	}

}
