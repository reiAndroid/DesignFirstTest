package com.example.design.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.design.R;
import com.example.design.model.Recommenders;

import java.util.ArrayList;

public class Recommender_Adapter extends RecyclerView.Adapter<Recommender_Adapter.ViewHolder>{


    private ArrayList<Recommenders> recommended = new ArrayList<>();
    private Context context;

    public Recommender_Adapter (){
    }

    public Recommender_Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommenders_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.movie_title.setText(recommended.get(position).getMovie_title());

        Glide.with(context)
                .asBitmap()
                .load(recommended.get(position).getMovie_pic())
                .into(holder.movie_pic);

    }

    @Override
    public int getItemCount() {
        return recommended.size();
    }

    public void setRecommended(ArrayList<Recommenders> recommended) {
        this.recommended = recommended;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ConstraintLayout recommenders_layout;
        private CardView recommenders_card;
        private ImageView movie_pic;
        private TextView movie_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            recommenders_layout = itemView.findViewById(R.id.recommenders_layout);
            recommenders_card = itemView.findViewById(R.id.recommenders_card);
            movie_pic = itemView.findViewById(R.id.movie_pic);
            movie_title = itemView.findViewById(R.id.movie_title);
        }
    }
}
