package dev.mtv.moviesApp;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies") //controller to handle this route or endpoint url
public class MovieController {

    @Autowired
    private MovieService movieService;//import MovieService
    @GetMapping //instantiate get method
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    //pathvariable... is useParams in reactjs. so this helps to convert the url path id to objectid
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }

}

//how the controller works is it gets a request and provides a response through the service class
//it delegates the task to the service class, to fetch all the movies from the database.
//the controller will not noe what happens within the service class.