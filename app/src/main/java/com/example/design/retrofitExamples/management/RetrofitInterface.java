package com.example.design.retrofitExamples.management;

import androidx.room.Dao;
import com.example.design.retrofitExamples.ui.comments.Comments;
import com.example.design.retrofitExamples.ui.posts.Posts;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

    /*
         Interface class of Retrofit.

         This class creates methods and functions to maintain Retrofit calls.
    */
@Dao
public interface RetrofitInterface {


    //Using GET request
    @GET("posts")
    Call<List<Posts>> getAllPosts();


    //Using GET request with Path annotation
    @GET("posts/{id}/comments")
    Call<List<Comments>> getComments(@Path("id") int postId);


    //Using GET request with Query annotation
    @GET("comments")
    Call<List<Comments>> getComment(
            @Query("postId") Integer postId,
            @Query("_sort") String id,
            @Query("_order") String order
    );

}