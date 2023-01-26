package com.example.design.model;

import android.widget.ImageView;

public class Categories {

    private String categoryImageView;
    private int id;

    public Categories(String categoryImageView, int id) {
        this.categoryImageView = categoryImageView;
        this.id = id;
    }

    public String getCategoryImageView() {
        return categoryImageView;
    }

    public void setCategoryImageView(String categoryImageView) {
        this.categoryImageView = categoryImageView;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "categoryImageView='" + categoryImageView + '\'' +
                ", id=" + id +
                '}';
    }
}
