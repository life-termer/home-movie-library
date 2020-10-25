package com.dsurchin.movielibrary.controller;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.dsurchin.movielibrary.entity.Movie;
import com.dsurchin.movielibrary.entity.Review;
import com.dsurchin.movielibrary.service.MovieService;

@Controller
@RequestMapping("/review")
public class ReviewController {
		
	// inject the movie Service
	@Autowired
	private MovieService movieService;
	
	private int movieId;
	
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(@RequestParam("movieId") int id,
								Model model) {
		
		// create model attribute to bind form data
		Review review = new Review();
		
		// get the movie from the service
		Movie movie = movieService.getMovie(id);
		
		
		model.addAttribute("review", review);
		model.addAttribute("movie", movie);
		
		movieId = id;
		
		return "review-form";
	}
	
	@PostMapping("/saveReview")
	public String saveMovie(@ModelAttribute("review") Review review)  {
		
		// save the movie using our service
		movieService.saveReview(review);
		
		// get the movie from the service
		Movie movie = movieService.getMovie(movieId);
		 
		// add review to the movie
		movie.addReviews(review);
		
		// save the movie using our service
		movieService.saveMovie(movie);
		
		System.out.println(movie.getReviews());  
		return("redirect:/movie/list");
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
		
		
		// delete poster form disk
		String poster =	"C:\\Users\\Admin\\Documents\\GitHub\\home-movie-library\\WebContent\\resources\\img\\" + id + ".jpg";
		
		try
        { 
            Files.deleteIfExists(Paths.get(poster)); 
        } 
        catch(NoSuchFileException e) 
        { 
            System.out.println("No such file/directory exists"); 
        } 
        catch(DirectoryNotEmptyException e) 
        { 
            System.out.println("Directory is not empty."); 
        } 
        catch(IOException e) 
        { 
            System.out.println("Invalid permissions."); 
        } 
          
        System.out.println("Deletion successful."); 
     
		
		// delete movie
		movieService.deleteMovie(id);
		
		return ("redirect:/movie/list");
	}
	
	

}
