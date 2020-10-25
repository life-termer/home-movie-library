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
@Table(name="review")
public class Review {

	// define the fields and mapping it to the database 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rev_id")
	private int revId;
	
	@Column(name="rev_name")
	private String revName;
	
	@Column(name="rev_rating")
	private int revRating;
	
	@Column(name="review")
	private String review;
	
	
	
	// define constructor
	public Review() {
		
	}
	
	// define getters and setters
	public int getRevId() {
		return revId;
	}

	public void setRevId(int revId) {
		this.revId = revId;
	}

	public String getRevName() {
		return revName;
	}

	public void setRevName(String revName) {
		this.revName = revName;
	}

	public int getRevRating() {
		return revRating;
	}

	public void setRevRating(int revRating) {
		this.revRating = revRating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}	

}
