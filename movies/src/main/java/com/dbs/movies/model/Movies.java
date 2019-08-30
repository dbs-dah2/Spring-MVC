package com.dbs.movies.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Movies implements Serializable, Comparable<Movies> {
    private long id;
    private String name;
    private double duration;
    private int rating;

    private Movies() {}
    
    public Movies(long id, String name, double duration, int rating) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movies)) return false;
        Movies movies = (Movies) o;
        return id == movies.id &&
                Double.compare(movies.duration, duration) == 0 &&
                rating == movies.rating &&
                Objects.equals(name, movies.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, rating);
    }

    @Override
    public int compareTo(Movies movie) {
        return (int)(this.id - movie.id);
    }


    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", rating=" + rating +
                '}';
    }
}
