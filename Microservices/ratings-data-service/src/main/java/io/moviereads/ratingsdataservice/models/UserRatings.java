package io.moviereads.ratingsdataservice.models;

import java.util.List;

public class UserRatings {

//    private String userId;
    private List<Rating> userRating;

    public UserRatings(){

    }

//    public String getUserId() {
//        return userId;
//    }

//    public void setUserId(String userId) {
//        this.userId = userId;
//    }

    public List<Rating> getRatings() {
        return userRating;
    }

    public void setRatings(List<Rating> userRating) {
        this.userRating = userRating;
    }
}
