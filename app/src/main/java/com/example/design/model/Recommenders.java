package com.example.design.model;

public class Recommenders {

    private String movie_title;
    private String movie_pic;

    public Recommenders(String movie_title, String movie_pic) {
        this.movie_title = movie_title;
        this.movie_pic = movie_pic;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_pic() {
        return movie_pic;
    }

    public void setMovie_pic(String movie_pic) {
        this.movie_pic = movie_pic;
    }

    @Override
    public String toString() {
        return "Recommenders{" +
                "movie_title='" + movie_title + '\'' +
                ", movie_pic='" + movie_pic + '\'' +
                '}';
    }
}
