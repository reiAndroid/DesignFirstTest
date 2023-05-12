package com.example.design.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.example.design.MovieData.Movie;
import java.util.List;
import com.example.design.R;
import com.example.design.ViewModel.MovieViewModel;

public class SearchFragment extends ListFragment implements SearchView.OnQueryTextListener {

    List<Movie> allMovie;

    private ArrayAdapter adapter;
    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_layout, container, false);
        TextView textView = (TextView) view.findViewById(R.id.empty);
        ListView listView = (ListView) view.findViewById(R.id.listViewSearch);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_view, menu);
        MenuItem searchItem = menu.findItem(R.id.searchViewToolbar);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Search movies...");


        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if(newText==null || newText.trim().isEmpty()) {
            resetSearch();
            return false;
        }

        System.out.println("print search query " + newText);

        MovieViewModel viewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        LiveData<List<Movie>> filteredMovies = viewModel.getAllMovies();
        for(Movie movie : allMovie) {
            if(!movie.movieName.toLowerCase().contains(newText.toLowerCase())) {
                filteredMovies.removeObservers(getViewLifecycleOwner());
            }
        }


        adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, (List) filteredMovies);
        setListAdapter(adapter);

        return false;
    }

    private void resetSearch() {
        adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, allMovie);
        setListAdapter(adapter);
    }
}