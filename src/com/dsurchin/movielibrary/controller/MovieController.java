package com.dsurchin.movielibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		// create model attribute to bind form data
		Movie movie = new Movie();
		
		model.addAttribute("movie", movie);
		
		return "movie-form";
	}
	
	@PostMapping("/saveMovie")
	public String saveMovie(@ModelAttribute("movie") Movie movie) {
		
		// save the movie using our service
		movieService.saveMovie(movie);
		
		return("redirect:/movie/list");
	}
	
	@GetMapping("/showMoviePage")
	public String showMoviePage(Model model) {
		
		return "movie-page";
	}

}
