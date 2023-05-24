package com.example.design.retrofitExamples.Data;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.design.retrofitExamples.ui.AlbumInterface;
import com.example.design.retrofitExamples.ui.Albums;
import com.example.design.retrofitExamples.ui.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitRepository {

    private final AlbumInterface albumInterface;

    public RetrofitRepository() {
        RetrofitInstance retrofitInstance = RetrofitInstance.getRetrofitInstance();
        albumInterface = retrofitInstance.getAlbumInterface();
    }

    public void getApiCall(MutableLiveData<List<Albums>> liveDataAlbums) {
        Call<List<Albums>> call = albumInterface.getAllAlbums();
        call.enqueue(new Callback<List<Albums>>() {
            @Override
            public void onResponse(@NonNull Call<List<Albums>> call, @NonNull Response<List<Albums>> response) {

                if (response.isSuccessful()) {
                    liveDataAlbums.setValue(response.body());
                } else {
                    liveDataAlbums.postValue(null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Albums>> call, @NonNull Throwable t) {

            }
        });
    }

}