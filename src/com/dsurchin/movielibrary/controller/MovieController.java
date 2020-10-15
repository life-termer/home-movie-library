package com.dsurchin.movielibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsurchin.movielibrary.dao.MovieDAO;
import com.dsurchin.movielibrary.entity.Movie;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	// inject the movie DAO
	@Autowired
	private MovieDAO movieDAO;
	
	@RequestMapping("/list")
	public String listMovie (Model model) {
		
		// get movies from the dao
		List<Movie> movies = movieDAO.getMovies();
		
		// add the movies to the model
		model.addAttribute("movies", movies);
		
		return "list-movies";
	}

}
