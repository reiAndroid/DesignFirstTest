package com.example.design.model;

public class Populars {

    private String movie_title;
    private String movie_image;
    private String category1;
    private String category2;
    private String category3;
    private int id;
    private int run_time;
    private String description;
    private String movie_language;
    private double rating;
    private String date_released;
    private boolean clicked;

    public Populars(String movie_title, String movie_image, String category1, String category2, String category3, int id, int run_time, String description, String movie_language, double rating, String date_released) {
        this.movie_title = movie_title;
        this.movie_image = movie_image;
        this.category1 = category1;
        this.category2 = category2;
        this.category3 = category3;
        this.id = id;
        this.run_time = run_time;
        this.description = description;
        this.movie_language = movie_language;
        this.rating = rating;
        this.date_released = date_released;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_image() {
        return movie_image;
    }

    public void setMovie_image(String movie_image) {
        this.movie_image = movie_image;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getCategory3() {
        return category3;
    }

    public void setCategory3(String category3) {
        this.category3 = category3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRun_time() {
        return run_time;
    }

    public void setRun_time(int run_time) {
        this.run_time = run_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMovie_language() {
        return movie_language;
    }

    public void setMovie_language(String movie_language) {
        this.movie_language = movie_language;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDate_released() {
        return date_released;
    }

    public void setDate_released(String date_released) {
        this.date_released = date_released;
    }

    @Override
    public String toString() {
        return "Populars{" +
                "movie_title='" + movie_title + '\'' +
                ", movie_image='" + movie_image + '\'' +
                ", category1='" + category1 + '\'' +
                ", category2='" + category2 + '\'' +
                ", category3='" + category3 + '\'' +
                ", id=" + id +
                ", run_time=" + run_time +
                ", description='" + description + '\'' +
                ", movie_language='" + movie_language + '\'' +
                ", rating=" + rating +
                ", date_released='" + date_released + '\'' +
                ", clicked=" + clicked +
                '}';
    }
}
