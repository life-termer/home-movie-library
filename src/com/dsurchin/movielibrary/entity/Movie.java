package com.dsurchin.movielibrary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="mov_descr")
	private String movDedcr;

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
	
	// define toString method
	@Override
	public String toString() {
		return "Movie [id=" + id + ", movTitle=" + movTitle + ", movYear=" + movYear + "]";
	}
	
	
	
}
