package com.example.design.DataExample;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class FavViewModel extends AndroidViewModel {

    private FavRepository eRepository;
    public final LiveData<List<Fav>> eFav;

    public FavViewModel (Application application) {
        super (application);

        eRepository = new FavRepository(application);
        eFav = eRepository.geteFav();
    }

    public LiveData<List<Fav>> geteFav() {
        return eFav;
    }

    public void insert (Fav fav) {
        eRepository.insert(fav);
    }
}