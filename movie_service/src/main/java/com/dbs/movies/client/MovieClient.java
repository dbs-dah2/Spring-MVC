package com.dbs.movies.client;

import com.dbs.movies.controller.MovieController;
import com.dbs.movies.model.Movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SpringBootApplication
@ComponentScan
public class MovieClient {
    private static MovieController movieController;
    public static void main(String[] args){
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.properties");
        ApplicationContext applicationContext = SpringApplication.run(MovieClient.class, args);
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
        System.out.println("-----------------------------------------");

        movieController.deleteMovie(3);
        movies = movieController.findAll();
        System.out.println(movies);
        System.out.println("-----------------------------------------");

        movieController.editMovie(new Movies(3,"Dilwale Dulhaniya Ley Jayenge",3.1,8),3);
        movies = movieController.findAll();
        System.out.println(movies);
        System.out.println("-----------------------------------------");

        Movies movie = movieController.find(4);
        System.out.println(movie);
        System.out.println("-----------------------------------------");
    }
}
