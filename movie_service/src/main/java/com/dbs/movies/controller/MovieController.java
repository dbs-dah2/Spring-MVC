package com.dbs.movies.controller;

import com.dbs.movies.model.Movies;
import com.dbs.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public void addMovie(Movies movie){
        this.movieService.addMovie(movie);
    }

    public void editMovie(Movies movie, int id){
        this.movieService.editMovie(movie,id);
    }

    public void deleteMovie(int id){
        this.movieService.deleteMovie(id);
    }

    public void deleteAll(){
        this.movieService.deleteAll();
    }

    public Movies find(int id){
        return this.movieService.find(id);
    }

    public List<Movies> findAll(){
        return this.movieService.findAll();
    }
}
