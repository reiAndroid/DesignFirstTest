package com.example.design.retrofitExamples.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.design.R;
import com.example.design.retrofitExamples.Adapter.PostsAdapter;
import com.example.design.retrofitExamples.Adapter.CommentsAdapter;
import com.example.design.retrofitExamples.Data.RetrofitViewModel;

public class RetrofitMainFragment extends Fragment {

    private CommentsAdapter commentsAdapter;
    private PostsAdapter postsAdapter;
    private RecyclerView recyclerView;
    private RetrofitViewModel retrofitViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_heroes, container, false);

        //Initialization
        recyclerView = view.findViewById(R.id.recyclerView);
        Button create_new_post_button = view.findViewById(R.id.create_new_post_button);

        //onClick to Create New Fragment
        create_new_post_button.setOnClickListener(v ->{
            CreateNew createNew = CreateNew.newInstance();
            createNew.show(getChildFragmentManager(), CreateNew.TAG);
        });

        postData();
        getPost();

        return view;
    }


    //Initializing the RecyclerView and set to it the adapter (Posts)
    private void postData() {

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        postsAdapter = new PostsAdapter();
        recyclerView.setAdapter(postsAdapter);

    }


    //Use ViewModel to display GET request (Posts)
    private void getPost() {

        setRetrofitViewModel();
        retrofitViewModel.getLiveDataPosts().observe(getViewLifecycleOwner(), posts -> {

            if (posts != null) {
                postsAdapter.setPosts(posts);
                postsAdapter.notifyDataSetChanged();
            } else {
                errorMessage();
            }

        });
        retrofitViewModel.makeApiCall();
    }



    //Initializing the RecyclerView and set to it the adapter (Comments)
    private void commentsData() {

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        commentsAdapter = new CommentsAdapter();
        recyclerView.setAdapter(commentsAdapter);

    }



    //Use ViewModel to display GET request (Comments)
    private void getComments() {
        setRetrofitViewModel();
        retrofitViewModel.getMutableLiveDataComments().observe(getViewLifecycleOwner(), comments -> {

            if (comments != null) {
                commentsAdapter.setCommentsList(comments);
                commentsAdapter.notifyDataSetChanged();
            } else {
                errorMessage();
            }

        });
        retrofitViewModel.getCommentsByPost();
    }



    //Use ViewModel to create a Post using POST request
    private void createPosts() {
        //TODO: CREATE POST
    }



    //Generate ViewModel
    private void setRetrofitViewModel() {
        retrofitViewModel = new ViewModelProvider(this).get(RetrofitViewModel.class);
    }


    //Show an Error Message if the Database does not have data
    private void errorMessage() {
        Toast.makeText(getContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
    }
}