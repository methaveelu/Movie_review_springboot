package dev.mtv.moviesApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate; // its a class to simplify the interaction with mongodb
    //sometimes repositories may not be sufficient to deal with more complex operations such as custom queries, this will allow you to promatically defien these queries
    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewRepository.insert(new Review(reviewBody, LocalDateTime.now(), LocalDateTime.now() ));

        mongoTemplate.update(Movie.class) // state that we want to update Movie class
                .matching(Criteria.where("imdbId").is(imdbId)) //check that it matches the id provided by user
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }

}
