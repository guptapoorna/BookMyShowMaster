package com.fs30.bookmyshow.service;

import com.fs30.bookmyshow.model.Genre;
import com.fs30.bookmyshow.model.Language;
import com.fs30.bookmyshow.model.Movie;
import com.fs30.bookmyshow.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MovieService {

     @Autowired
     private MovieRepository movieRepository;

     public List<Movie> getMovies() {
         return movieRepository.getMovies();
     }
    public Movie getMoviesBasedOnImage(String id) {
        return movieRepository.getMoviesBasedOnImage(id);
    }

    public List<Genre> getGenres() {
        return movieRepository.getGenres();
    }
    public List<Language> getLanguages() {
        return movieRepository.getLanguages();
    }

    public Movie saveMovies(Movie movie) {
        return movieRepository.saveMovie(movie);
    }

//    public Movie deleteMovies(Movie movie) {
//        return movieRepository.deleteMovies(movie);
//    }
public List<Movie> getMoviesBasedOnGenre(String genreId) {
    return movieRepository.getMoviesBasedOnGenre(genreId);
}

    public List<Movie> getMoviesBasedOnLanguage(String languageId) {
        return movieRepository.getMoviesBasedOnLanguage(languageId);
    }

}
