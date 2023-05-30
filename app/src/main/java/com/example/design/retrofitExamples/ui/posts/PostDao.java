package com.example.design.retrofitExamples.ui.posts;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

@Dao
public interface PostDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPostsDao(Posts...posts);

    @Delete
    void deleteOnePost(Posts...post);

    @Query("DELETE FROM posts")
    void deleteAllPosts();


    @Query("SELECT * FROM posts")
    LiveData<List<Posts>> getAllPostsDao();
}