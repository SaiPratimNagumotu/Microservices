package io.moviereads.movieinfoservice.resource;

import io.moviereads.movieinfoservice.model.info;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoService {

    @RequestMapping("/{movieID}")
    public info getInfo(@PathVariable("movieID") String movieID){
                return new info(movieID,"Titanic","Its a romantic movie.");
    }


}
