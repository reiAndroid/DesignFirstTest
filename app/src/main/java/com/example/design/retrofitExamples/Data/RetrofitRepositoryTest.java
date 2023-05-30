package com.example.design.retrofitExamples.Data;


import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.example.design.retrofitExamples.ui.posts.Posts;
import com.example.design.retrofitExamples.ui.posts.PostDao;
import com.example.design.retrofitExamples.management.RetrofitDatabaseTest;
import com.example.design.retrofitExamples.management.RetrofitInstance;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


    /*
        Main Retrofit class.

        RetrofitRepositoryTest is the class that contains certain functions
        to maintain Database operation of RetrofitDatabaseTest class.

        getInstance() --> This function can be used to get the instance of
        RetrofitRepositoryTest class. This function will return RetrofitRepositoryTest class
        with its own functions to maintain different actions about databases.

        The constructor contains Context as a parameter. This can allows users to
        create a new Object of RetrofitDatabaseTest class and then to maintain different operations.

    */

public class RetrofitRepositoryTest {
    private static RetrofitRepositoryTest repositoryTest;
    private RetrofitInstance retrofitInstance;
    private final PostDao dao;
    private final LiveData<List<Posts>> liveDataPosts;

    public static RetrofitRepositoryTest getInstance(Context context) {

        if (repositoryTest == null) {
            repositoryTest = new RetrofitRepositoryTest(context);
        }
        return repositoryTest;
    }

    public RetrofitRepositoryTest(Context context) {
        RetrofitDatabaseTest retrofitDatabaseTest = RetrofitDatabaseTest.getRetrofitDatabaseTest(context);
        dao = retrofitDatabaseTest.retrofitDao();
        liveDataPosts = dao.getAllPostsDao();
    }

    /*
        The following functions can only be used for Retrofit calls.
        They cannot be used for Room Database operations.
        All functions will use RetrofitInstance class to operate different calls.

        .
        .
        .
        .

        getPostData() --> It will use retrofit instance and retrofit interface
        to create and get the objects from API.
     */

    public void getPostsData() {

        getRetrofitInstances();
        retrofitInstance.getInterface().getAllPosts().enqueue(new Callback<List<Posts>>() {

            @Override
            public void onResponse(@NonNull Call<List<Posts>> call, @NonNull Response<List<Posts>> response) {

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        for (int postId = 0; postId < response.body().size(); postId++) {
                            Posts posts = response.body().get(postId);
                            dao.insertPostsDao(posts);
                        }
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Posts>> call, @NonNull Throwable t) {
                throwableMessage(t);
            }
        });
    }


    /*
        The following functions can be used only for Room Database operation.
        They cannot be used for Retrofit calls.
        All functions will use the ExecutorService interface class to maintain
        different actions in Database.

        .
        .
        .
        .

        insertOnePost() -->  This function can be used to add/insert/enter
        a new, different Object of Posts class.

        deleteAllPosts() --> This function can be used to delete from
        database all existing Objects of Posts class.

        deleteOnePost() --> This function can be used to delete fom database
        only one existing Object at a moment of Posts class.

        getLiveDataPosts() --> This function can be used to return the Object type
        of LiveData<List<T>> instance.

     */

    public void insertOnePost(Posts posts) {
        RetrofitDatabaseTest.retrofitExecutor.execute(()-> dao.insertPostsDao(posts));
    }

    public void deleteAllPosts() {
        RetrofitDatabaseTest.retrofitExecutor.execute(dao::deleteAllPosts);
    }

    public void deleteOnePost(Posts posts) {
        RetrofitDatabaseTest.retrofitExecutor.execute(()-> dao.deleteOnePost(posts));
    }


    public LiveData<List<Posts>> getLiveDataPosts() {
        return liveDataPosts;
    }



    /*

        Private functions to only be used within this class

        throwableMessage() --> Use this throwable and its backtrace to the standard error stream.
        This method prints a stack trace for this Throwable object on the error output stream that is the value of the field System.err.

        getRetrofitInstances() --> Use this function to get the instance of the RetrofitInstance management class.

     */
    private void throwableMessage(Throwable throwable) {
        throwable.printStackTrace();
    }

    private void getRetrofitInstances() {
        retrofitInstance = RetrofitInstance.getRetrofitInstance();
    }

}