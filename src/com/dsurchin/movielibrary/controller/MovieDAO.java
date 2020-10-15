package com.dsurchin.movielibrary.controller;

import java.util.List;

import com.dsurchin.movielibrary.entity.Movie;

//Data Access Object interface
public interface MovieDAO {

		public List<Movie> getMovies();
		
		public void saveMovie (Movie movie);
		
		public Movie getMovie(int id);
		
		public void deleteMovie(int id);
}
