package com.example.design.Activities;

import static com.example.design.MovieData.MovieDatabase.INSTANCE;
import static com.example.design.MovieData.MovieDatabase.service;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.design.Fragment.BottomFragmentMovie;
import com.example.design.MovieData.MovieDao;
import com.example.design.MovieData.MovieModel;
import com.example.design.MovieData.MovieModelClass;
import com.example.design.MovieHolder.MovieListAdapter;
import com.example.design.R;

public class MovieDatabaseExample extends AppCompatActivity {

    /*private BottomFragmentMovie fragmentMovie;
    private Button button, cancel_movies, set_movies;
    private FragmentManager fragmentManager;
    private Dialog dialog;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_database_example);

       /* button = findViewById(R.id.add_new_movie_button);

        button.setOnClickListener(v -> {
            fragmentMovie = new BottomFragmentMovie();
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setCustomAnimations(R.anim.slide_from_bottom, R.anim.slide_out_top, R.anim.slide_in_top, R.anim.slide_out_bottom)
                    .replace(R.id.movie_container, fragmentMovie)
                    .addToBackStack(null)
                    .commit();

            button.setVisibility(View.GONE);
        });

        dialog = new Dialog(MovieDatabaseExample.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.dialog_bottom_layout);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);

                cancel_movies = dialog.findViewById(R.id.cancel_movies);
                set_movies = dialog.findViewById(R.id.set_movies);

                cancel_movies.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(MovieDatabaseExample.this, "Nothing to Save", Toast.LENGTH_SHORT).show();
                    }
                });

                set_movies.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(MovieDatabaseExample.this, "Nothing here", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();
            }
        });


        RecyclerView recyclerViewMovie = findViewById(R.id.recycler_movie_database);
        final MovieListAdapter movieListAdapter = new MovieListAdapter(new MovieListAdapter.MovieDiff());
        recyclerViewMovie.setAdapter(movieListAdapter);
        recyclerViewMovie.setLayoutManager(new LinearLayoutManager(this));

        MovieModelClass movieModelClass = new ViewModelProvider(this).get(MovieModelClass.class);
        movieModelClass.getMovie_model_name().observe(this, movieListAdapter::submitList);
        movieModelClass.getMovie_model_rate().observe(this, movieListAdapter::submitList);*/

    }

    /*@Override
    public void onBackPressed() {
        button.setVisibility(View.VISIBLE);
        fragmentManager.beginTransaction().remove(fragmentMovie).commit();
        super.onBackPressed();
    }

    public static RoomDatabase.Callback movieRoomDatabaseCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            service.execute(() -> {
                MovieDao movieDao = INSTANCE.movieDao();
                movieDao.deleteAll();


                MovieModel model = new MovieModel("Anna", 9);
                movieDao.insert(model);

                model = new MovieModel("Smile", 7);
                movieDao.insert(model);

                model = new MovieModel("Avengers End-Game", 9);
                movieDao.insert(model);

                model = new MovieModel("Avengers Infinity-War", 9);
                movieDao.insert(model);

            });
        }
    };*/
}