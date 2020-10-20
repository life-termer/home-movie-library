package com.dsurchin.movielibrary.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="genres")
public class Genres {
	// define the fields and mapping it to the database 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="gen_id")
	private int genId;
	
	@Column(name="gen_title")
	private String genTitle;
	
	// add many to many mapping
	@ManyToMany(fetch=FetchType.LAZY,
				cascade = {CascadeType.PERSIST, CascadeType.MERGE,
				CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
				name="movie_genres",
				joinColumns=@JoinColumn(name="gen_id"),
				inverseJoinColumns=@JoinColumn(name="mov_id")
				)
	private List<Movie> movies;
	
	// define constructor
	public Genres() {
		
	}
	
	// define getters and setters
	public int getGenId() {
		return genId;
	}

	public void setGenId(int genId) {
		this.genId = genId;
	}

	public String getGenTitle() {
		return genTitle;
	}

	public void setGenTitle(String genTitle) {
		this.genTitle = genTitle;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	// add a convenience method for movies
	public void addMovies(Movie movie) {
		if(movies == null) {
			movies = new ArrayList<>();
		}
		movies.add(movie);
	}

}
