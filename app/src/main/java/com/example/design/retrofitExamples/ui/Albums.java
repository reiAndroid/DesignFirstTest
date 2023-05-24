package com.example.design.retrofitExamples.ui;

public class Albums {

    int userId;
    int id;
    String title;


    //Constructor
    public Albums(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }


    //Setters
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    //Getters
    public int getuserId() {
        return userId;
    }

    public int getid() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}