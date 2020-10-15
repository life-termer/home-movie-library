package com.dsurchin.movielibrary.service;

import java.util.List;

import com.dsurchin.movielibrary.entity.Movie;

public interface MovieService {

	
	public List<Movie> getMovies();

	public void saveMovie(Movie movie);
}
