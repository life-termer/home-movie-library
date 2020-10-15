package com.dsurchin.movielibrary.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dsurchin.movielibrary.entity.Movie;

@Repository				// DAO implementations
public class MovieDAOImpl implements MovieDAO {
	
	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Movie> getMovies() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query and sort by last name [ASC|DESC]
		Query<Movie> query = 
				currentSession.createQuery("from Movie order by movTitle", Movie.class);
		
		// execute query and get result list
		List<Movie> movies = query.getResultList();
		
		// return the result
		
		return movies;
	}

	@Override
	public void saveMovie(Movie movie) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the movie to the database
		currentSession.save(movie);
	}

	@Override
	public Movie getMovie(int id) {
		return null;
	}

	@Override
	public void deleteMovie(int id) {
	}

}
