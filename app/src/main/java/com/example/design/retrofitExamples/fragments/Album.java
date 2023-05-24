package com.example.design.retrofitExamples.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.design.R;
import com.example.design.retrofitExamples.Adapter.AlbumAdapter;
import com.example.design.retrofitExamples.Data.RetrofitViewModel;

public class Album extends Fragment {

    private AlbumAdapter albumAdapter;
    private RecyclerView recyclerViewAlbums;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_heroes, container, false);

        //Initialization
        recyclerViewAlbums = view.findViewById(R.id.album_recyclerView);
        recyclerViewData();
        setData();

        return view;
    }

    private void recyclerViewData() {
        //Set the adapter to RecyclerView
        recyclerViewAlbums.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        albumAdapter = new AlbumAdapter();
        recyclerViewAlbums.setAdapter(albumAdapter);
    }

    private void setData() {
        //ViewModel
        RetrofitViewModel retrofitViewModel = new ViewModelProvider(this).get(RetrofitViewModel.class);
        retrofitViewModel.getLiveDataAlbums().observe(getViewLifecycleOwner(), albums -> {
            if (albums != null) {
                albumAdapter.setAlbums(albums);
                albumAdapter.notifyDataSetChanged();
            } else {
                Toast.makeText(getContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });
        retrofitViewModel.makeApiCall();
    }

    /* private void getAlbum() {
    *
        Call<List<Albums>> listCall = RetrofitInstance.getRetrofitInstance()
                .getAlbumInterface()
                .getAllAlbums();

        listCall.enqueue(new Callback<List<Albums>>() {
            @Override
            public void onResponse(@NonNull Call<List<Albums>> call, @NonNull Response<List<Albums>> response) {

                albums = response.body();

                assert albums != null;
                for (Albums albums1 : albums) {

                    String command = "";
                    command += "UserId: " + albums1.getuserId() + "\n";
                    command += "ID: " + albums1.getid() + "\n";
                    command += "Title: " + albums1.getTitle() + "\n\n";

                    postTextView.append(command);
                    System.out.println("Albums data: " + albums1.getuserId());
                }
            }


            @Override
            public void onFailure(@NonNull Call<List<Albums>> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }*/

    /*    private void getPosts() {
    *
            Call<List<HeroNameModel>> post = RetrofitInstance.getInstance()
                    .getMyApi()
                    .getPost();

            post.enqueue(new Callback<List<HeroNameModel>>() {
                @Override
                public void onResponse(@NonNull Call<List<HeroNameModel>> call, @NonNull Response<List<HeroNameModel>> response) {

                    if (!response.isSuccessful()) {
                        postTextView.setText("Code:" + response.code());
                        return;
                    }

                    List<HeroNameModel> texts = response.body();

                    assert texts != null;
                    for (HeroNameModel posts: texts) {
                        String model = "";
                        model += "User ID: " + posts.getUserId() + "\n";
                        model += "ID: " + posts.getId() + "\n";
                        model += "Title: " + posts.getTitle() + "\n";
                        model += "Body: " + posts.getBody() + "\n\n";

                        postTextView.append(model);
                        //TODO: Check the ID
                        System.out.println("retrofit data:" + posts.getId());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<HeroNameModel>> call, @NonNull Throwable t) {
                    Toast.makeText(getContext(), "An error has occurred", Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }*/
}