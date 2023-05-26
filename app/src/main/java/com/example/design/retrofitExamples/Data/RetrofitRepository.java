package com.example.design.retrofitExamples.Data;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.design.retrofitExamples.ui.comments.Comments;
import com.example.design.retrofitExamples.ui.posts.RetrofitInterface;
import com.example.design.retrofitExamples.ui.posts.Posts;
import com.example.design.retrofitExamples.ui.posts.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitRepository {

    private final RetrofitInterface retrofitInterface;

    public RetrofitRepository() {
        RetrofitInstance retrofitInstance = RetrofitInstance.getRetrofitInstance();
        retrofitInterface = retrofitInstance.getPostsInterface();
    }


    //Just Get Data (Posts)
    public void getApiCall(MutableLiveData<List<Posts>> liveDataPosts) {
        Call<List<Posts>> call = retrofitInterface.getAllPosts();
        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(@NonNull Call<List<Posts>> call, @NonNull Response<List<Posts>> response) {

                if (response.isSuccessful()) {
                    liveDataPosts.setValue(response.body());
                } else {
                    liveDataPosts.postValue(null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Posts>> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }


    //Using Path (GET request)
    public void getCommentsFromApi(MutableLiveData<List<Comments>> liveData) {
        Call<List<Comments>> listCall = retrofitInterface.getComments(2);
        listCall.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(@NonNull Call<List<Comments>> call, @NonNull Response<List<Comments>> response) {

                if (response.isSuccessful()) {
                    liveData.setValue(response.body());
                } else {
                    liveData.postValue(null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Comments>> call, @NonNull Throwable t) {
                throwableMessage(t);
            }
        });
    }


    //Using Query (GET request)
    public void getCommentsByPost(MutableLiveData<List<Comments>> listComments) {
        Call<List<Comments>> callComments = retrofitInterface.getComment(2, "id", "desc");
        callComments.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(@NonNull Call<List<Comments>> call, @NonNull Response<List<Comments>> response) {

                if (response.isSuccessful()) {
                    listComments.setValue(response.body());
                } else {
                    listComments.postValue(null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Comments>> call, @NonNull Throwable t) {
                throwableMessage(t);
            }
        });
    }



    public void updatePost() {
        //TODO: Create a post
    }



    public void throwableMessage(Throwable throwable) {
        throwable.printStackTrace();
    }

}