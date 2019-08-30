package com.dbs.movies.service;

import com.dbs.movies.model.Movies;

import java.util.List;

public interface MovieService {
    public void addMovie(Movies movie);

    public void editMovie(Movies movie, int id);

    public void deleteMovie(int movieId);

    public void deleteAll();

    public Movies find(int id);

    public List<Movies> findAll();
}
