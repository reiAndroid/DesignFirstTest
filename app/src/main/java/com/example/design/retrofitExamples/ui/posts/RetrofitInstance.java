package com.example.design.retrofitExamples.ui.posts;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static RetrofitInstance retrofitInstance = null;
    private final RetrofitInterface retrofitInterface;
    private static final String ALBUMS_URL = "https://jsonplaceholder.typicode.com/";

    private RetrofitInstance() {

        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl(ALBUMS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit2.create(RetrofitInterface.class);
    }

    public static synchronized RetrofitInstance getRetrofitInstance() {
        if (retrofitInstance == null) {
            retrofitInstance = new RetrofitInstance();
        }
        return retrofitInstance;
    }

    public RetrofitInterface getPostsInterface() {
        return retrofitInterface;
    }

}