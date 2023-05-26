package com.example.design.retrofitExamples.ui.posts;

import androidx.room.Entity;

@Entity(tableName = "posts")
public class Posts {

    int userId;
    int id;
    String title;
    String body;


    //Constructor
    public Posts(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
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

    public void setBody(String body) {
        this.body = body;
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

    public String getBody() {
        return body;
    }
}