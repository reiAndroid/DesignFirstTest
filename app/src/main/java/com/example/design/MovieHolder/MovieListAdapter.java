package com.example.design.MovieHolder;

import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.example.design.MovieData.Movie;
import com.example.design.R;
import com.example.design.ViewModel.MovieViewModel;
import com.example.design.datastore.SaveData;

public class MovieListAdapter extends ListAdapter<Movie, MovieViewHolder> implements Filterable {
    private MovieViewModel movieViewModel;

    public MovieListAdapter (@NonNull DiffUtil.ItemCallback<Movie> diffCallBackMovie, MovieViewModel movieViewModel) {
        super(diffCallBackMovie);
        this.movieViewModel = movieViewModel;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MovieViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Movie currentMovie = getItem(position);
        holder.bind(currentMovie.getMovieName());
        holder.bind1(currentMovie.getMovieRate());


        holder.itemView.findViewById(R.id.textMovieName).setOnClickListener(v ->{

            //Using SharedPrefs
            /*SaveData.setString("movieName", currentMovie.getMovieName());
            SaveData.setInt("movieRate", currentMovie.getMovieRate());
            SaveData.setInt("movieId", currentMovie.getId());*/

            Navigation.findNavController(holder.itemView).navigate(R.id.updateFragment);
        });

        holder.itemView.findViewById(R.id.deleteOneItem).setOnClickListener(v -> {
            AlertDialog.Builder deleteAlert = new AlertDialog.Builder(holder.itemView.getContext());
            deleteAlert.setTitle("Delete " + currentMovie.getMovieName());
            deleteAlert.setMessage("Are you sure you want to delete "+ currentMovie.getMovieName() + " movie?");
            deleteAlert.setPositiveButton("Yes", ((dialog, which) -> movieViewModel.delete(currentMovie)));
            deleteAlert.setNegativeButton("No", ((dialog, which) -> Toast.makeText(holder.itemView.getContext(), "Nothing to delete", Toast.LENGTH_SHORT).show()));

            deleteAlert.show();
        });
    }

    @Override
    protected Movie getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public Filter getFilter() {
        /*if(valueFilter==null) {

            valueFilter=new ValueFilter();

        }

        return valueFilter;*/
        return null;
    }

    public static class MovieDiff extends DiffUtil.ItemCallback<Movie> {

        @Override
        public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem==newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.getMovieName().equals(newItem.getMovieName());
        }
    }
}