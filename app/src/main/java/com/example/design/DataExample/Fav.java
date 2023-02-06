package com.example.design.DataExample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="fav_table")
public class Fav {

    @PrimaryKey
    @NonNull
    @ColumnInfo (name = "fav")
    private String fav;

    public Fav(@NonNull String fav) {
        this.fav=fav;
    }

    public String getFav() {
        return this.fav;
    }
}