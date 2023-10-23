package dev.mtv.moviesApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

//data schema for movies data
@Document(collection = "movies")
@Data //from lombok project.. takes care of getters..setters and string methods
@AllArgsConstructor // for creating a constructor that takes all the private fields as shown as args
@NoArgsConstructor // another constructor that takes no params
public class Movie {
    @Id// this annotation tells the framework that id will be the unique identifier each movie in database
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private List<String> genres;
    private String poster;
    private List<String> backdrops;
    @DocumentReference// this means that the database will only store the IDs of review. and reviews will be in separate collection
    private List<Review> reviewIds;//creating relational database

}
