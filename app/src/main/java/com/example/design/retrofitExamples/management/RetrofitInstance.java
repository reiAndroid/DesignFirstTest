package com.example.design.retrofitExamples.management;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


 /*
    Retrofit management class.

    Use the instances of this class to create and manage Retrofit API calls.

    .
    .
    .
    .

    RetrofitInstance() --> Use this function to create a Retrofit call.

    getRetrofitInstance() --> Use this function to get instances of Retrofit.
        Using singleton pattern for restrictions the instantiation of a class.
        Ensures that only one instance of the class exists in the Java Virtual Machine.

    getPostsInterface() --> Use this function to get the Interface class of Retrofit.

    .
    .
    .
    .

  */

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

    public RetrofitInterface getInterface() {
        return retrofitInterface;
    }

}