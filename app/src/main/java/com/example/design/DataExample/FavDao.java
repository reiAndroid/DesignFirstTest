package com.example.design.DataExample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert (Fav fav);

    @Query("DELETE FROM fav_table")
    void deleteAll();

    @Query("SELECT * FROM fav_table ORDER BY fav ASC")
    LiveData<List<Fav>> getAlphabetizedWord();
}