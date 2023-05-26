package com.example.design.retrofitExamples.ui.posts;

import androidx.room.Dao;
import com.example.design.retrofitExamples.ui.comments.Comments;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Dao
public interface RetrofitInterface {

    //Using GET request
    @GET("posts")
    Call<List<Posts>> getAllPosts();


    //Using GET request with Path
    @GET("posts/{id}/comments")
    Call<List<Comments>> getComments(@Path("id") int postId);


    //Using GET request with Query
    @GET("comments")
    Call<List<Comments>> getComment(
            @Query("postId") Integer postId,
            @Query("_sort") String id,
            @Query("_order") String order
    );

    //Using POST request
    @POST("posts")
    Call<List<Posts>> createPost(@Body Posts posts);


    //Using POST request with FormUrlencoded

}