package com.dsurchin.movielibrary.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dsurchin.movielibrary.entity.Genres;
import com.dsurchin.movielibrary.entity.Movie;
import com.dsurchin.movielibrary.entity.Review;

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
		currentSession.saveOrUpdate(movie);
	}

	@Override
	public Movie getMovie(int id) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve / read from database using the primary key
		Movie movie = currentSession.get(Movie.class, id);
		
		return movie;
	}

	@Override
	public void deleteMovie(int id) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete movie from database using the primary key
		Query query = currentSession.createQuery("delete from Movie where id=:movieId");
		
		query.setParameter("movieId", id);
		
		query.executeUpdate();
	}


	@Override
	public List<Genres> getGenres() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query and sort by last name [ASC|DESC]
		Query<Genres> query = 
				currentSession.createQuery("from Genres order by gen_title", Genres.class);
		
		// execute query and get result list
		List<Genres> genres = query.getResultList();
		
		
		// return the result
		
		return genres;
	}

	@Override
	public List<Review> getReviews() {

		
		return null;
	}

}
