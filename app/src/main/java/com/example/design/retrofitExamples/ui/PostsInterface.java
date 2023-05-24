package com.example.design.retrofitExamples.ui;

import com.example.design.retrofitExamples.Comments.Comments;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostsInterface {

    @GET("posts")
    Call<List<Posts>> getAllPosts();

    @GET("albums/{id}/comments")
    Call<List<Comments>> getComments(@Path("id") int postId);
}
