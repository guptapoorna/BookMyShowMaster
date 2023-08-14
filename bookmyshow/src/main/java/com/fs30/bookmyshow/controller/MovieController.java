package com.fs30.bookmyshow.controller;

import com.fs30.bookmyshow.client.BookingsFeignClient;
import com.fs30.bookmyshow.model.*;
import com.fs30.bookmyshow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** combination of Controllers and ResponseBody annotations
in rest service controllers we need to add annotation @ResponseBody with each method
so rather than using at each method we can use it with controller annotations itself.
so use @RestController
 */

@RestController
@RequestMapping("api/movies")
@CrossOrigin(origins="http://localhost:4200/")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    BookingsFeignClient bookingsFeignClient;

    /**
     * @value work with only spring managed beans like , repository, controllers and service classes
     * from pojo or any other file, this annotation won't pick values from properties file.
     * if filed is not variable in properties file then , server won't start up .
     * so default value can be mentioned while using @Value annotation.
     *
     */

    @Value("${app.name: default name app}")
    private String appNameFromAppProperties;


//    @GetMapping("/movies")
//    public String displayHomePage(Model model, @AuthenticationPrincipal OAuth2User principal) {
//        if (null != principal) {
//            String name = principal.getAttribute("name");
//            model.addAttribute("name", name);
//        }
//        return "movies";
//
//    }

    @GetMapping("/all")
    public List<Movie>  getMovies() {
        // Using @Value annotation field name here
        System.out.println("Application name is :: " + appNameFromAppProperties);
        return movieService.getMovies();
    }
    @GetMapping("/{movieID}")
    public Movie getMoviesBasedOnImage(@PathVariable String movieID) {
        System.out.println("selected Movie is :: " + movieID);

        return movieService.getMoviesBasedOnImage(movieID);
    }





    @GetMapping("/genres")
    public List<Genre> getGenres() {
        return movieService.getGenres();
    }

    @GetMapping("/genres/{id}")
    public List<Movie> getMoviesBasedOnGenre(@PathVariable String id) {
        System.out.println("selected genre is " + id);
        return movieService.getMoviesBasedOnGenre(id);
    }
    @GetMapping("/languages")
    public List<Language> getLanguages() {
        return movieService.getLanguages();
    }

    @GetMapping("/languages/{id}")
    public List<Movie> getMoviesBasedOnLanguage(@PathVariable String id) {
        System.out.println("selected languages is " + id);
        return movieService.getMoviesBasedOnLanguage(id);
    }

@PostMapping("/savemovie")
public Movie saveMovies(@RequestBody Movie movie) {
    return movieService.saveMovies(movie);
}

@PutMapping("/updatemovie")
public Movie updateMovie(@RequestBody Movie movie) {
    return movieService.saveMovies(movie);
}

@PostMapping("/booking/tickets")
    public BookingResponse bookDirectTickets(@RequestBody BookingModel bookingModel){
        String message = bookingsFeignClient.getBookingDetails(bookingModel);
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setSuccessMessage(message);
        return bookingResponse;
    }

}
