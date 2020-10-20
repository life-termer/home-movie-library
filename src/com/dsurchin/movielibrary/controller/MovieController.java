package com.dsurchin.movielibrary.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dsurchin.movielibrary.entity.Genres;
import com.dsurchin.movielibrary.entity.Movie;
import com.dsurchin.movielibrary.entity.Review;
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
		List<Genres> genres = movieService.getGenres();
		
		// add the movies to the model
		model.addAttribute("movies", movies);
		model.addAttribute("genres", genres);
		
		return "list-movies";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		// create model attribute to bind form data
		Movie movie = new Movie();
		
		// get reviews from the Service
		List<Genres> genres = movieService.getGenres();
		List<String> gTitles = new ArrayList<>();
		for(Genres gen : genres) {
			gTitles.add(gen.getGenTitle());
		}
		
		model.addAttribute("movie", movie);
		model.addAttribute("genres", genres);
		model.addAttribute("gTitles", gTitles);
		
		return "movie-form";
	}
	
	@PostMapping("/saveMovie")
	public String saveMovie(@ModelAttribute("movie") Movie movie,
				@RequestParam("file") CommonsMultipartFile file,  
				HttpSession session) throws Exception {
		
		System.out.println("Movie");
		System.out.println(movie.getGenres());
		
		// save the movie using our service
		movieService.saveMovie(movie);
		
		System.out.println("Saved");
		System.out.println(movie.getGenres());
		
		// Creating the directory to store poster image
		//String rootPath = System.getProperty("catalina.home");
		File dir = new File("C:\\Users\\Admin\\Documents\\GitHub\\home-movie-library\\WebContent\\resources\\img");      
		String name = movie.getId() + ".jpg";
		Path p = Paths.get(dir + File.separator + name);
		
		
		
		// Create the file on server
		if(!Files.exists(p)) {
		File serverFile = new File(dir + File.separator + name);	
	    byte[] bytes = file.getBytes();  
	    
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(serverFile));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();  
		}
	    
		return("redirect:/movie/list");
	}
	
	@GetMapping("/moviePage")
	public String showMoviePage(@RequestParam("movieId") int id,
									Model model) {
		// get the movie from the service
		Movie movie = movieService.getMovie(id);
		
		// set movie as a model attribute to pre-populate the form
		model.addAttribute("movie", movie);
		
		return "movie-page";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("movieId") int id,
									Model model) {
		
		// get the movie from the service
		Movie movie = movieService.getMovie(id);
		
		List<Genres> genres = movieService.getGenres();
		List<String> gTitles = new ArrayList<>();
		for(Genres gen : genres) {
			gTitles.add(gen.getGenTitle());
		}
		
		// set movie as a model attribute to pre-populate the form
		model.addAttribute("movie", movie);
		model.addAttribute("genres", genres);
		model.addAttribute("gTitles", gTitles);
		
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
