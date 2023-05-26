package com.example.design.retrofitExamples.Data;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.design.retrofitExamples.ui.comments.Comments;
import com.example.design.retrofitExamples.ui.posts.Posts;
import java.util.List;


public class RetrofitViewModel extends AndroidViewModel {

    MutableLiveData<List<Posts>> liveDataPosts;
    MutableLiveData<List<Comments>> mutableLiveDataComments;
    private final RetrofitRepository retrofitRepository;

    public RetrofitViewModel(@NonNull Application application) {
        super(application);

        retrofitRepository = new RetrofitRepository();
        liveDataPosts = new MutableLiveData<>();
        mutableLiveDataComments = new MutableLiveData<>();
    }

    public MutableLiveData<List<Posts>> getLiveDataPosts() {
        return liveDataPosts;
    }

    public MutableLiveData<List<Comments>> getMutableLiveDataComments() {
        return mutableLiveDataComments;
    }

    public void getCommentsFromApi() {
        retrofitRepository.getCommentsFromApi(mutableLiveDataComments);
    }

    public void makeApiCall() {
        retrofitRepository.getApiCall(liveDataPosts);
    }

    public void getCommentsByPost() {
        retrofitRepository.getCommentsByPost(mutableLiveDataComments);
    }

}