package io.moviereads.moviecatalogservice.resource;

import io.moviereads.moviecatalogservice.models.CatalogItem;
import io.moviereads.moviecatalogservice.models.Rating;
import io.moviereads.moviecatalogservice.models.UserRatings;
import io.moviereads.moviecatalogservice.models.info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalog {

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private WebClient.Builder webClient;

    @RequestMapping("/{userID}")
    public List<CatalogItem> getCatalogItem(@PathVariable("userID")String userId){

//        List<Rating> ratings = Arrays.asList(
//                new Rating("1234","2"),
//                new Rating("5678","3")
//        );
        UserRatings ratings = restTemplate.getForObject("http://ratings-data-service/ratings/users/" + userId,UserRatings.class);
        return ratings.getRatings().stream().map(rating -> {
            info infoObject = restTemplate.getForObject("http://movie-info-service/info/" + rating.getMovieId() ,info.class);
            // info infoObject = webClient.build().get().uri("http://localhost:8082/info/" + rating.getMovieId()).retrieve().bodyToMono(info.class).block();
            return new CatalogItem(infoObject.getMovieName(), infoObject.getMovieDesc(), rating.getRating());
        }).collect(Collectors.toList());
    }
}
