package com.dbs.movies.service;

import com.dbs.movies.dao.MovieDAO;
import com.dbs.movies.model.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieDAO movieDao;

    public void addMovie(Movies movie) {
        movieDao.addMovie(movie);

    }

    public void editMovie(Movies Movies, int id) {
        movieDao.editMovie(Movies, id);
    }

    public void deleteMovie(int id) {
        movieDao.deleteMovie(id);
    }

    public void deleteAll() {
        movieDao.deleteAll();
    }

    public Movies find(int id) {
        return movieDao.find(id);
    }

    public List< Movies > findAll() {
        return movieDao.findAll();
    }
}
