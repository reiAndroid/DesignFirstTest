package com.example.design.retrofitExamples.ui;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AlbumInterface {

    @GET("albums")
    Call<List<Albums>> getAllAlbums();
}
