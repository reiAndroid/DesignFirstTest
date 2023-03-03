package com.example.design.Fragment;

import static com.example.design.MovieData.MovieDB.INSTANCE;
import static com.example.design.MovieData.MovieDB.service;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.design.MovieData.Movie;
import com.example.design.MovieData.MoviesDao;
import com.example.design.MovieHolder.MovieListAdapter;
import com.example.design.R;
import com.example.design.ViewModel.MovieViewModel;

public class MovieDataExample extends Fragment {

    private MovieViewModel movieViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movie_data_example, container, false);

        //Initialize Elements
        TextView textHello = view.findViewById(R.id.textHello);
        LinearLayout layoutMainButtons = view.findViewById(R.id.layoutMainButtons);
        Button addMovieButton = view.findViewById(R.id.addMovieButton);
        Button deleteAllButton = view.findViewById(R.id.deleteAllButton);

        //Initialize RecyclerView
        RecyclerView movieRecyclerView = view.findViewById(R.id.movieRecyclerView);

        //Initialize Buttons
        addMovieButton = view.findViewById(R.id.addMovieButton);
        deleteAllButton = view.findViewById(R.id.deleteAllButton);

        //Read and show data
        MovieListAdapter movieListAdapter = new MovieListAdapter(new MovieListAdapter.MovieDiff());
        movieRecyclerView.setAdapter(movieListAdapter);
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Object of ViewModel
        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        movieViewModel.getAllMovies().observe(getViewLifecycleOwner(), movieListAdapter::submitList);

        //onClick (Add) button
        addMovieButton.setOnClickListener(view1 -> Navigation.findNavController(view).navigate(R.id.insertFragment));

        //onClick (Delete) button
        deleteAllButton.setOnClickListener(view1 -> {

            //Show an alert dialog
            AlertDialog.Builder alert = new AlertDialog.Builder(requireContext());
            alert.setTitle("Delete All");
            alert.setMessage("Are you sure you want to delete all movies?");

            //Create Delete function
            alert.setPositiveButton("Delete",
                    (dialog, which) -> movieViewModel.deleteAll());

            //Other button
            alert.setNegativeButton("Cancel",
                    ((dialog, which) -> {
                        Toast.makeText(getContext(), "Nothing deleted!", Toast.LENGTH_SHORT).show();
                    }));

            alert.show();
        });

        return view;
    }


    public static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            service.execute(() -> {
                MoviesDao mDao = INSTANCE.moviesDao();

                Movie movie = new Movie(0, "Anna", 6);
                mDao.insertMovie(movie);
            });
        }
    };
}