package com.example.design.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.design.R;
import com.example.design.model.Populars;
import com.google.android.material.chip.Chip;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {

    private ScrollView scroll_view;
    private ConstraintLayout parent;
    private ImageView movie_trailer;
    private LinearLayout category_layout, description_layout, details_layout;
    private Chip cat_1, cat_2, cat_3;
    private TextView description_text, text_description, text_details, text_release, date_released, text_runTime, movie_runTime, text_language, movie_language, text_rating, movie_rating, text_related;
    private View divider2, divider3,divider4,divider5,divider6;
    private RecyclerView recycler_view_related;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initialization_of_elements();

        Toolbar toolbar_select_movie = findViewById(R.id.toolbar_select_movie);
        setSupportActionBar(toolbar_select_movie);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setTitle("Movie Title");

        //Data
        Populars pop = new Populars("Avengers Endgame", "https://terrigen-cdn-dev.marvel.com/content/prod/2x/MLou2_Payoff_1-Sht_Online_DOM_v7_Sm.jpg", "# Action", "# Adventure", "# Sci-fi", 1111, 181, "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.", "English", 8.4, "April 25, 2019");
        setData(pop);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void initialization_of_elements(){

        //Here we initialize the elements inside our Layout.xml file
        scroll_view = findViewById(R.id.scroll_view);
        parent = findViewById(R.id.parent);
        movie_trailer = findViewById(R.id.movie_trailer);
        category_layout = findViewById(R.id.category_layout);
        description_layout = findViewById(R.id.description_layout);
        details_layout = findViewById(R.id.details_layout);
        cat_1 = findViewById(R.id.cat_1);
        cat_2 = findViewById(R.id.cat_2);
        cat_3 = findViewById(R.id.cat_3);
        description_text = findViewById(R.id.description_text);
        text_description = findViewById(R.id.text_description);
        text_details = findViewById(R.id.text_details);
        text_release = findViewById(R.id.text_release);
        date_released = findViewById(R.id.date_released);
        text_runTime = findViewById(R.id.text_runTime);
        movie_runTime = findViewById(R.id.movie_runTime);
        text_language = findViewById(R.id.text_language);
        movie_language = findViewById(R.id.movie_language);
        text_rating = findViewById(R.id.text_rating);
        movie_rating = findViewById(R.id.movie_rating);
        text_related = findViewById(R.id.text_related);
        divider2 = findViewById(R.id.divider2);
        divider3 = findViewById(R.id.divider3);
        divider4 = findViewById(R.id.divider4);
        divider5 = findViewById(R.id.divider5);
        divider6 = findViewById(R.id.divider6);
        recycler_view_related = findViewById(R.id.recycler_view_related);
    }

    public void setData(Populars pop) {

        //Here we get the data from other activities and set them to this activity
        cat_1.setText(pop.getCategory1());
        cat_2.setText(pop.getCategory2());
        cat_3.setText(pop.getCategory3());

        text_description.setText(pop.getDescription());

        date_released.setText(pop.getDate_released());
        movie_runTime.setText(String.valueOf(pop.getRun_time()+ " minutes"));
        movie_language.setText(pop.getMovie_language());
        movie_rating.setText(String.valueOf(pop.getRating()));
    }
}