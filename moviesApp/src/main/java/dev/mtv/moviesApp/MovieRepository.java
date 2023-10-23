package dev.mtv.moviesApp;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //repos ar used to access and perform CRUD functions on your data
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    //to search movie by accessing other property
    Optional<Movie> findMovieByImdbId(String imdbId);//custom made find array method
}
