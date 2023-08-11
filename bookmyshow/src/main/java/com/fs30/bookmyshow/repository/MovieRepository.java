package com.fs30.bookmyshow.repository;

import com.fs30.bookmyshow.model.Genre;
import com.fs30.bookmyshow.model.Language;
import com.fs30.bookmyshow.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Movie> getMovies() {
        Query query = new Query();
        List<Movie> listOfMovies = mongoTemplate.find(query, Movie.class);
        System.out.println("getMovies" + listOfMovies.get(0));
        return listOfMovies;
    }

    public Movie getMoviesBasedOnImage(String movieID) {
        Query query = new Query();
        query.addCriteria(Criteria.where("movieId").is(movieID));
        List<Movie> listOfMovies = mongoTemplate.find(query, Movie.class);
        System.out.println("getMovies" + listOfMovies);
        if (null!= listOfMovies) {
            return listOfMovies.get(0);
        } else {
            return null;
        }
    }

    public List<Movie> getMoviesBasedOnGenre(String genreID) {
        Query query = new Query();
        query.addCriteria(Criteria.where("genre").is(genreID));
        List<Movie> listOfMovies = mongoTemplate.find(query, Movie.class);
        System.out.println("getMovies" + listOfMovies.get(0));
        return listOfMovies;
    }
    public List<Movie> getMoviesBasedOnLanguage(String languageID) {
        Query query = new Query();
        query.addCriteria(Criteria.where("language").is(languageID));
        List<Movie> listOfMovies = mongoTemplate.find(query, Movie.class);
        return listOfMovies;
    }

    public List<Genre> getGenres() {
        Query query = new Query();
        List<Genre> listOfGenres = mongoTemplate.find(query, Genre.class);
        return listOfGenres;
    }

    public List<Language> getLanguages() {
        Query query = new Query();
        List<Language> listOfLanguage = mongoTemplate.find(query, Language.class);
        return listOfLanguage;
    }

    public Movie saveMovie(Movie movie) {
        Query query = new Query();
        Movie savedMovie = mongoTemplate.save(movie, "Movie");
        return savedMovie;
    }

    public void deleteMovies(Movie movie) {
//        Query query = new Query();
//
//        return savedMovie;
    }
}
