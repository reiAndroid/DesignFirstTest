package com.example.design.retrofitExamples.ui;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static RetrofitInstance retrofitInstance = null;
    private final AlbumInterface albumInterface;
    private static final String ALBUMS_URL = "https://jsonplaceholder.typicode.com/";

    private RetrofitInstance() {

        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl(ALBUMS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        albumInterface = retrofit2.create(AlbumInterface.class);
    }

    public static synchronized RetrofitInstance getRetrofitInstance() {
        if (retrofitInstance == null) {
            retrofitInstance = new RetrofitInstance();
        }
        return retrofitInstance;
    }

    public AlbumInterface getAlbumInterface() {
        return albumInterface;
    }

}