package com.dsurchin.movielibrary.service;

import java.util.List;

import com.dsurchin.movielibrary.entity.Genres;
import com.dsurchin.movielibrary.entity.Movie;
import com.dsurchin.movielibrary.entity.Review;

public interface MovieService {

	
	public List<Movie> getMovies();

	public void saveMovie(Movie movie);

	public Movie getMovie(int id);

	public void deleteMovie(int id);

	public List<Review> getReviews();

	public List<Genres> getGenres();
}
