package com.example.design.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design.Adapter.Populars_Adapter;
import com.example.design.R;
import com.example.design.Adapter.Recommender_Adapter;
import com.example.design.model.Recommenders;
import com.example.design.model.Populars;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ConstraintLayout home_nav_layout, home_popular_movie_layout, home_recommended_movie_layout;
    private RecyclerView home_recView_popular, home_recView_recommended;
    private Populars_Adapter populars_adapter;
    private Recommender_Adapter recommender_adapter;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        home_recView_popular = view.findViewById(R.id.home_recView_popular);
        home_recView_recommended = view.findViewById(R.id.home_recView_recommended);

        popData();
        recData();
        return view;
    }

    public void popData(){

        populars_adapter = new Populars_Adapter(this.getContext());

        home_recView_popular.setAdapter(populars_adapter);
        home_recView_popular.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<Populars> populars = new ArrayList<>();

        populars.add(new Populars("Avengers Endgame", "https://terrigen-cdn-dev.marvel.com/content/prod/2x/MLou2_Payoff_1-Sht_Online_DOM_v7_Sm.jpg", "# Action", "# Adventure", "# Sci-fi", 1111, 181, "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.", "English", 8.3, "April 25, 2019"));
        populars.add(new Populars("Minions:The Rise of Gru", "https://www.themoviedb.org/t/p/original/4dBDk1LPdvdhcZdjQBmdXwiVKUA.jpg", "# Animation", "# Adventure", "# Family", 1112, 87, "The untold story of one twelve-year-old's dream to become the world's greatest supervillain.", "English", 6.6, "July 1, 2022"));
        populars.add(new Populars("Black Panther: Wakanda Forever", "https://m.media-amazon.com/images/M/MV5BNTM4NjIxNmEtYWE5NS00NDczLTkyNWQtYThhNmQyZGQzMjM0XkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_.jpg", "# Action", "# Drama", "# Sci-fi", 1113, 161, "The people of Wakanda fight to protect their home from intervening world powers as they mourn the death of King T'Challa.", "English", 7.2, "November 11, 2022"));
        populars.add(new Populars("Smile", "https://m.media-amazon.com/images/M/MV5BZjE2ZWIwMWEtNGFlMy00ZjYzLWEzOWEtYzQ0MDAwZDRhYzNjXkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_.jpg", "# Horror", "# Thriller", "# Mystery", 1114, 115, "After witnessing a bizarre, traumatic incident involving a patient, Dr. Rose Cotter starts experiencing frightening occurrences that she can't explain.", "English", 6.5, "September 26, 2022"));
        populars.add(new Populars("Black Adam", "https://m.media-amazon.com/images/M/MV5BYzZkOGUwMzMtMTgyNS00YjFlLTg5NzYtZTE3Y2E5YTA5NWIyXkEyXkFqcGdeQXVyMjkwOTAyMDU@._V1_.jpg", "# Fantasy", "# Action", "# Adventure", 1115, 125, "Nearly 5,000 years after he was bestowed with the almighty powers of the Egyptian gods--and imprisoned just as quickly--Black Adam is freed from his earthly tomb, ready to unleash his unique form of justice on the modern world.", "English", 6.6, "October 21, 2022"));

        populars_adapter.setPopulars_movies(populars);
    }

    public void recData(){

        recommender_adapter = new Recommender_Adapter(this.getContext());

        home_recView_recommended.setAdapter(recommender_adapter);
        home_recView_recommended.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<Recommenders> recommenders = new ArrayList<>();

        recommenders.add(new Recommenders("Titanic", "https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_.jpg"));
        recommenders.add(new Recommenders("Iron-Man", "https://image.invaluable.com/housePhotos/AERGroup/94/657294/H22061-L187864611_original.jpg"));
        recommenders.add(new Recommenders("The Nun", "https://m.media-amazon.com/images/M/MV5BMjM3NzQ5NDcxOF5BMl5BanBnXkFtZTgwNzM4MTQ5NTM@._V1_.jpg"));
        recommenders.add(new Recommenders("Wall-E", "https://m.media-amazon.com/images/M/MV5BMjExMTg5OTU0NF5BMl5BanBnXkFtZTcwMjMxMzMzMw@@._V1_.jpg"));
        recommenders.add(new Recommenders("Interstellar", "https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg"));

        recommender_adapter.setRecommended(recommenders);
    }

}