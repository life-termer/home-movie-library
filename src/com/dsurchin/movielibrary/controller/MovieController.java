package com.dsurchin.movielibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/moviePage")
	public String showMoviePage(Model model) {
		
		return "movie-page";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("movieId") int id,
									Model model) {
		
		// get the movie from the service
		Movie movie = movieService.getMovie(id);
		
		// set movie as a model attribute to pre-populate the form
		model.addAttribute("movie", movie);
		
		// send over to our form
		
		return "movie-form";
	}
	
	@GetMapping("/delete")
	public String deleteMovie(@RequestParam("movieId") int id) {
		
		// delete movie
		movieService.deleteMovie(id);
		
		return ("redirect:/movie/list");
		
	}
	

}
