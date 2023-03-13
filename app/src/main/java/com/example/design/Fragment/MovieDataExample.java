package com.example.design.Fragment;

import static com.example.design.MovieData.MovieDB.INSTANCE;
import static com.example.design.MovieData.MovieDB.service;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.design.MovieData.Movie;
import com.example.design.MovieData.MoviesDao;
import com.example.design.MovieHolder.MovieListAdapter;
import com.example.design.R;
import com.example.design.ViewModel.MovieViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MovieDataExample extends Fragment {

    private MovieViewModel movieViewModel;
    private MovieListAdapter movieListAdapter;
    private RecyclerView movieRecyclerView;
    private Button addMovieButton, deleteAllButton;
    private SearchView searchView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movie_data_example, container, false);

        //Initialize Elements
        addMovieButton = view.findViewById(R.id.addMovieButton);
        deleteAllButton = view.findViewById(R.id.deleteAllButton);
        searchView = view.findViewById(R.id.search_view);

        //Initialize RecyclerView
        movieRecyclerView = view.findViewById(R.id.movieRecyclerView);

        //Initialize Buttons
        addMovieButton = view.findViewById(R.id.addMovieButton);
        deleteAllButton = view.findViewById(R.id.deleteAllButton);

        //Read and show data
        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        movieListAdapter = new MovieListAdapter(new MovieListAdapter.MovieDiff(), movieViewModel);
        movieRecyclerView.setAdapter(movieListAdapter);
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Object of ViewModel
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
                    ((dialog, which) -> Toast.makeText(getContext(), "Nothing deleted!", Toast.LENGTH_SHORT).show()));

            alert.show();
        });

        searchMovies();

        return view;
    }

    private void searchMovies(){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                System.out.println("print query " + query + " " + movieListAdapter.getCurrentList().size());
                if (movieListAdapter != null)
                    movieListAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        inflater.inflate(R.menu.search_view, menu);
        MenuItem item = menu.findItem(R.id.searchViewToolbar);
        System.out.println("print movies list1 " );

        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query!=null) {
                    getItemsFromDB(query);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                System.out.println("print movies list2 " + newText);
                if (newText!=null) {
                    getItemsFromDB(newText);
                }
                return true;
            }
        });
    }

    private void getItemsFromDB(String searchMovie) {
        /*String searchText;
        searchText = "%"+searchMovie+"%";

        List<Movie> movies = new ArrayList<>();
        LiveData<List<Movie>> liveDataMovie = movieViewModel.searchMovies(searchText);

        liveDataMovie.observe(this, movies1 -> {
            movies1.addAll(movies1);
            movieListAdapter.submitList(movies1);
            movieRecyclerView.setAdapter(movieListAdapter);

            Log.e("List", movies.toString());*/
        List<Movie> movies = new ArrayList<>();
        searchMovie = searchMovie.toLowerCase(Locale.getDefault());
        movies.clear();
        System.out.println("print movies list " + movies);

        if (searchMovie.length()==0) {
            movies.addAll(movieListAdapter.getCurrentList());
        } else {
            for (Movie movie: movieListAdapter.getCurrentList()) {
                if (movie.movieName.toLowerCase(Locale.getDefault()).contains(searchMovie)) {
                    movies.add(movie);
                }
            }
        }
    }
}