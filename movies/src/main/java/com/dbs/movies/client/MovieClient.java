package com.dbs.movies.client;

import com.dbs.movies.controller.MovieController;
import com.dbs.movies.model.Movies;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MovieClient {
    private static MovieController movieController;
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        movieController = applicationContext.getBean(MovieController.class);

        movieController.deleteAll();

        Movies sanju = new Movies(2,"Sanju",2.0,8);
        Movies ddlj = new Movies(3,"Dilwale Dulhaniya Ley Jayenge",3.1,8);
        Movies vickyDonor = new Movies(4,"Vicky Donor",2.5,7);
        movieController.addMovie(sanju);
        movieController.addMovie(ddlj);
        movieController.addMovie(vickyDonor);

        List<Movies> movies = movieController.findAll();
        System.out.println(movies);
        

        movieController.deleteMovie(3);
        movies = movieController.findAll();
        System.out.println(movies);
        

        movieController.editMovie(new Movies(3,"Dilwale Dulhaniya Ley Jayenge",3.1,8),3);
        movies = movieController.findAll();
        System.out.println(movies);
        

        Movies movie = movieController.find(4);
        System.out.println(movie);
        
    }
}
