package com.example.design.retrofitExamples.Data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.design.retrofitExamples.ui.Albums;

import java.util.List;


public class RetrofitViewModel extends AndroidViewModel {

    MutableLiveData<List<Albums>> liveDataAlbums;
    private final RetrofitRepository retrofitRepository;

    public RetrofitViewModel(@NonNull Application application) {
        super(application);

        retrofitRepository = new RetrofitRepository();
        liveDataAlbums = new MutableLiveData<>();
    }

    public MutableLiveData<List<Albums>> getLiveDataAlbums() {
        return liveDataAlbums;
    }

    public void makeApiCall() {
        retrofitRepository.getApiCall(liveDataAlbums);
    }

}