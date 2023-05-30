package com.example.design.retrofitExamples.Data;


import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.design.retrofitExamples.ui.posts.Posts;
import java.util.List;

public class RetrofitViewModelTest extends AndroidViewModel {

    private RetrofitRepositoryTest repositoryTestViewModel;
    private LiveData<List<Posts>> listLiveDataViewModel;

    public RetrofitViewModelTest(@NonNull Application application) {
        super(application);

        repositoryTestViewModel = RetrofitRepositoryTest.getInstance(application);
        listLiveDataViewModel = repositoryTestViewModel.getLiveDataPosts();

    }

    public void insertOnePostInDb(Posts posts) {
        repositoryTestViewModel.insertOnePost(posts);
    }

    public void deleteAllPostsFromDb() {
        repositoryTestViewModel.deleteAllPosts();
    }

    public void deleteOnePostFromDb(Posts post) {
        repositoryTestViewModel.deleteOnePost(post);
    }

    public LiveData<List<Posts>> getListLiveDataViewModel() {
        return listLiveDataViewModel;
    }
}
