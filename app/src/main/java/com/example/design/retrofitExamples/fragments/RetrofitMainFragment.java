package com.example.design.retrofitExamples.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.design.R;
import com.example.design.retrofitExamples.Adapter.PostsAdapter;
import com.example.design.retrofitExamples.Data.RetrofitRepositoryTest;
import com.example.design.retrofitExamples.Data.RetrofitViewModelTest;


public class RetrofitMainFragment extends Fragment {

    private PostsAdapter postsAdapter;
    private RecyclerView recyclerView;
    private RetrofitRepositoryTest repositoryTestFragment;
    private RetrofitViewModelTest retrofitViewModelTest;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_heroes, container, false);

        //Initialization
        recyclerView = view.findViewById(R.id.recyclerView);
        Button create_new_post_button = view.findViewById(R.id.create_new_post_button);
        Button delete_all_posts = view.findViewById(R.id.delete_all_posts);
        repositoryTestFragment = new RetrofitRepositoryTest(getContext());

        //onClick to Create New Fragment
        create_new_post_button.setOnClickListener(v ->{
            CreateNew createNew = CreateNew.newInstance();
            createNew.show(getChildFragmentManager(), CreateNew.TAG);
        });

        //onClick to Delete All
        delete_all_posts.setOnClickListener(v -> {

            AlertDialog.Builder alert = new AlertDialog.Builder(requireContext());
            alert.setTitle("DELETE ALL");
            alert.setMessage("Are you sure you want to delete all posts?");

            alert.setNegativeButton("No", (dialog, which) ->
                    Toast.makeText(getContext(), "Nothing to delete!", Toast.LENGTH_SHORT).show());

            alert.setPositiveButton("Yes", (dialog, which) -> retrofitViewModelTest.deleteAllPostsFromDb());

            alert.show();
        });

        postData();
        setPosts();
        deleteOnePost();


        return view;
    }

    //Initializing the RecyclerView and set to it the adapter (Posts)
    private void postData() {

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        postsAdapter = new PostsAdapter();
        recyclerView.setAdapter(postsAdapter);

    }

    private void setPosts() {
        retrofitViewModelTest = new ViewModelProvider(this).get(RetrofitViewModelTest.class);
        retrofitViewModelTest.getListLiveDataViewModel().observe(getViewLifecycleOwner(), posts -> {

            if (posts != null) {
                postsAdapter.setPosts(posts);
            } else {
                errorMessage();
            }
        });
        repositoryTestFragment.getPostsData();
    }


    private void deleteOnePost() {
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                int position = viewHolder.getAdapterPosition();

                retrofitViewModelTest.deleteOnePostFromDb(postsAdapter.getPostAt(position));
                postsAdapter.notifyItemRemoved(position);
                Toast.makeText(getContext(), "Post deleted!", Toast.LENGTH_SHORT).show();
            }
        });

        helper.attachToRecyclerView(recyclerView);
    }


    //Show an Error Message if the Database does not have data
    private void errorMessage() {
        Toast.makeText(getContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
    }
}