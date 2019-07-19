package io.moviereads.ratingsdataservice.resource;

import io.moviereads.ratingsdataservice.models.Rating;
import io.moviereads.ratingsdataservice.models.UserRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/ratings")
public class Ratings {

    @RequestMapping("/{movieID}")  // 1. API Endpoint
    public Rating getRatings(@PathVariable("movieID") String movieID){
        return new Rating(movieID ,"4");
    }

    @RequestMapping("users/{userId}")  // 2. API Endpoint
    public UserRatings getUserRatings(@PathVariable("userId") String userId){

        List<Rating> userRates = Arrays.asList(
                new Rating("123","2"),
                new Rating("456","3")
        );

        UserRatings userRate = new UserRatings();
        userRate.setRatings(userRates);
        return userRate;
    }
}
