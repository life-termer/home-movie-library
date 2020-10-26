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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity					// Java class that is mapped to a database table
@Table(name="movie") 	// mapping to database table
public class Movie {

	// mapping to the fields of database tables
	@Id					// primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //let MySQL handle the generation AUTO_INCREMENT
	@Column(name="id")	// mapping fields to database column
	private int id;
	
	@Column(name="mov_title")
	private String movTitle;
	
	@Column(name="mov_year")
	private int movYear;
	
	@Column(name="mov_time")
	private int movTime;
	
	@Column(name="mov_lang")
	private String movLang;
	
	@Column(name="mov_rel_dt")
	private String movDate;
	
	@Column(name="mov_rel_country")
	private String movCountry;
	
	@Column(name="mov_genre")
	private String movGenre;
	
	@Column(name="mov_cast")
	private String movCast;
	
	@Column(name="mov_director")
	private String movDir;
	
	@Column(name="mov_descr")
	private String movDedcr;
	
	@Column(name="mov_storyline")
	private String movStory;
	
	
	
	// add many to many mapping
	@ManyToMany(fetch=FetchType.LAZY,
				cascade = {CascadeType.PERSIST, CascadeType.MERGE,
				CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
				name="movie_genres",
				joinColumns=@JoinColumn(name="mov_id"),
				inverseJoinColumns=@JoinColumn(name="gen_id")
				)
	private List<Genres> genres;
	
	// add one to many mapping
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="mov_id")
	private List<Review> reviews;

	// define constructor
	public Movie() {
		}
	
	// define getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovTitle() {
		return movTitle;
	}

	public void setMovTitle(String movTitle) {
		this.movTitle = movTitle;
	}

	public int getMovYear() {
		return movYear;
	}

	public void setMovYear(int movYear) {
		this.movYear = movYear;
	}

	public int getMovTime() {
		return movTime;
	}

	public void setMovTime(int movTime) {
		this.movTime = movTime;
	}

	public String getMovLang() {
		return movLang;
	}

	public void setMovLang(String movLang) {
		this.movLang = movLang;
	}

	public String getMovDate() {
		return movDate;
	}

	public void setMovDate(String movDate) {
		this.movDate = movDate;
	}

	public String getMovCountry() {
		return movCountry;
	}

	public void setMovCountry(String movCountry) {
		this.movCountry = movCountry;
	}

	public String getMovDedcr() {
		return movDedcr;
	}

	public void setMovDedcr(String movDedcr) {
		this.movDedcr = movDedcr;
	}
	
	public String getMovStory() {
		return movStory;
	}

	public void setMovStory(String movStory) {
		this.movStory = movStory;
	}

	public List<Genres> getGenres() {
		return genres;
	}
	

	public String getMovGenre() {
		return movGenre;
	}

	public void setMovGenre(String movGenre) {
		this.movGenre = movGenre;
	}

	public String getMovCast() {
		return movCast;
	}

	public void setMovCast(String movCast) {
		this.movCast = movCast;
	}

	public String getMovDir() {
		return movDir;
	}

	public void setMovDir(String movDir) {
		this.movDir = movDir;
	}

	public void setGenres(List<Genres> genres) {
		this.genres = genres;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	// define toString method
	@Override
	public String toString() {
		return "Movie [id=" + id + ", movTitle=" + movTitle + ", movYear=" + movYear + "]";
	}	
	
	// add a convenience method for reviews
	public void addReviews(Review review) {
		if(reviews == null) {
			reviews = new ArrayList<>();
		}
		reviews.add(review);
	}
	
}
