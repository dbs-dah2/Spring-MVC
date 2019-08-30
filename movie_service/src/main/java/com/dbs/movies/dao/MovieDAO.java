package com.dbs.movies.dao;

import com.dbs.movies.model.Movies;

import java.util.List;

public interface MovieDAO {
    public void addMovie(Movies movie);

    public void editMovie(Movies movie, int id);

    public void deleteMovie(int id);

    public void deleteAll();

    public Movies find(int id);

    public List<Movies> findAll();
}
