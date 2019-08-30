package com.dbs.movies.dao;

import com.dbs.movies.model.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDAOImpl implements MovieDAO{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addMovie(Movies movie) {
        jdbcTemplate.update("INSERT INTO movies (Id, Name, Duration, Rating) VALUES (?, ?, ?, ?)",
                movie.getId(), movie.getName(),movie.getDuration(),movie.getRating());
        System.out.println("Movie Added Successfully!!");
        System.out.println(movie);
    }

    @Override
    public void editMovie(Movies movie, int id) {
        jdbcTemplate.update("UPDATE movies SET Name = ? , Duration = ? ,Rating = ? WHERE Id = ? ",
                         movie.getName(),movie.getDuration(),movie.getRating(),id);
        System.out.println("Movie Updated !!");
    }

    @Override
    public void deleteMovie(int id) {
        jdbcTemplate.update("DELETE from movies WHERE id = ? ", id);
        System.out.println("Movie Deleted!!");
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update("DELETE from movies");
        System.out.println("All Movies Deleted!!");
    }

    @Override
    public Movies find(int id) {
        Movies movie = jdbcTemplate.queryForObject("SELECT * FROM movies where Id = ? ",
                new Object[] { id }, new BeanPropertyRowMapper<Movies>(Movies.class));

        return movie;
    }

    @Override
    public List<Movies> findAll() {
        List < Movies > movies = jdbcTemplate.query("SELECT * FROM movies", new BeanPropertyRowMapper<Movies>(Movies.class));
        return movies;
    }
}
