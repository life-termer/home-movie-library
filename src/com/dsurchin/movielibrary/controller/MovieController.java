package com.dsurchin.movielibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsurchin.movielibrary.dao.MovieDAO;
import com.dsurchin.movielibrary.entity.Movie;
import com.dsurchin.movielibrary.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	// inject the movie Service
	@Autowired
	private MovieService movieService;
	
	// only handles GET method, any other HTTP REQUEST methods will be rejected
	@GetMapping("/list")
	public String listMovie (Model model) {
		
		// get movies from the Service
		List<Movie> movies = movieService.getMovies();
		
		// add the movies to the model
		model.addAttribute("movies", movies);
		
		return "list-movies";
	}

}
