package com.example.design.DataExample;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class FavRepository {

    private FavDao eFavDao;
    private LiveData<List<Fav>> eFav;

    FavRepository (Application application) {
        FavRoomDatabase favDB = FavRoomDatabase.getDatabase(application);
        eFavDao = favDB.favDao();
        eFav = eFavDao.getAlphabetizedWord();
    }

    LiveData<List<Fav>> geteFav() {
        return eFav;
    }

    void insert (Fav fav) {
        FavRoomDatabase.databaseWriteExecutor.execute(() -> {
            eFavDao.insert(fav);
        });
    }
}