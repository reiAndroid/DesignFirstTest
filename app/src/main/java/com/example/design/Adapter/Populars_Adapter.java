package com.example.design.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.design.Activities.MainActivity2;
import com.example.design.R;
import com.example.design.model.Populars;

import java.util.ArrayList;

public class Populars_Adapter extends RecyclerView.Adapter<Populars_Adapter.ViewHolder> {

    private ArrayList<Populars> populars_movies = new ArrayList<>();
    private Context pContext;


    public Populars_Adapter(Context context) {
        this.pContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final boolean[] fav = {false};

        holder.movieTitle.setText(populars_movies.get(position).getMovie_title());

        Glide.with(pContext)
                .asBitmap()
                .load(populars_movies.get(position).getMovie_image())
                .into(holder.movie_image);

        holder.fav_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!fav[0]) {
                    holder.fav_btn.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    Toast.makeText(pContext, "Added to Favorites", Toast.LENGTH_SHORT).show();
                    fav[0] = true;
                } else {
                    holder.fav_btn.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
                    Toast.makeText(pContext, "Removed from Favorites", Toast.LENGTH_SHORT).show();
                    fav[0] = false;
                }
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pContext, MainActivity2.class);
                pContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return populars_movies.size();
    }

    public void setPopulars_movies(ArrayList<Populars> populars_movies) {
        this.populars_movies = populars_movies;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout popular_layout, movie_title_layout;
        private RelativeLayout image_layout;
        private CardView cardView;
        private ImageView movie_image;
        private TextView movieTitle;

        private ImageButton fav_btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_layout = itemView.findViewById(R.id.image_layout);
            popular_layout = itemView.findViewById(R.id.popular_layout);
            cardView = itemView.findViewById(R.id.cardView);
            movie_title_layout = itemView.findViewById(R.id.movie_title_layout);
            movie_image = itemView.findViewById(R.id.movie_image);
            movieTitle = itemView.findViewById(R.id.movieTitle);
            fav_btn = itemView.findViewById(R.id.fav_btn);
        }
    }
}