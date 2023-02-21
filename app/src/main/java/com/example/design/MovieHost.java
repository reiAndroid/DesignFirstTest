package com.example.design;

import static com.example.design.MovieData.MovieDatabase.INSTANCE;
import static com.example.design.MovieData.MovieDatabase.service;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.design.Fragment.BottomFragmentMovie;
import com.example.design.MovieData.MovieDao;
import com.example.design.MovieData.MovieModel;
import com.example.design.MovieData.MovieModelClass;
import com.example.design.MovieHolder.MovieListAdapter;

import java.util.Objects;


public class MovieHost extends Fragment {

    private Button add_new_movie_button;
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movie_host, container, false);

        add_new_movie_button = view.findViewById(R.id.add_new_movie_button);
        recyclerView = view.findViewById(R.id.recycler_movie_database);

        add_new_movie_button.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.bottomFragmentMovie));

        final MovieListAdapter movieListAdapter = new MovieListAdapter(new MovieListAdapter.MovieDiff());
        recyclerView.setAdapter(movieListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        MovieModelClass movieModelClass = new ViewModelProvider(this).get(MovieModelClass.class);
        movieModelClass.getMovie_model_name().observe(getViewLifecycleOwner(), movieListAdapter::submitList);
        movieModelClass.getMovie_model_rate().observe(getViewLifecycleOwner(), movieListAdapter::submitList);

        return view;
    }


    public static RoomDatabase.Callback movieRoomDatabaseCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            service.execute(() -> {
                MovieDao movieDao = INSTANCE.movieDao();
                movieDao.deleteAll();

                MovieModel model = new MovieModel("Anna", 7);
                movieDao.insert(model);

                model = new MovieModel("Avengers EndGame", 9);
                movieDao.insert(model);

                model = new MovieModel("Smile", 8);
                movieDao.insert(model);

                model = new MovieModel("Black Panther", 8);
                movieDao.insert(model);

                model = new MovieModel("Black Adam", 6);
                movieDao.insert(model);
            });
        }
    };
}