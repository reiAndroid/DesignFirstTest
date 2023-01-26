package com.example.design.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.design.R;
import com.example.design.model.Categories;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<Categories> categories = new ArrayList<>();
    private Context catContext;

    public CategoryAdapter(Context catContext) {
        this.catContext = catContext;
    }

    public Context getCatContext() {
        return catContext;
    }

    public void setCatContext(Context catContext) {
        this.catContext = catContext;
    }

    public CategoryAdapter(ArrayList<Categories> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.frag_cat_movie_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       String picUrl = " ";

        switch (position) {

            case 0: {
                picUrl = "action";
                break;
            }
            case 1: {
                picUrl = "advent";
                break;
            }
            case 2: {
                picUrl = "anim";
                break;
            }

            case 3: {
                picUrl = "com";
                break;
            }

            case 4: {
                picUrl = "dram";
                break;
            }

            case 5: {
                picUrl = "fanta";
                break;
            }

            case 6: {
                picUrl = "horr";
                break;
            }

            case 7: {
                picUrl = "music";
                break;
            }

            case 8: {
                picUrl = "myster";
                break;
            }

            case 9: {
                picUrl = "roman";
                break;
            }

            case 10: {
                picUrl = "science";
                break;
            }

            case 11: {
                picUrl = "thrill";
                break;
            }

            case 12: {
                picUrl = "west";
                break;
            }
        }

        @SuppressLint("DiscouragedApi") int drawableResource = holder.itemView
                .getContext()
                .getResources()
                .getIdentifier(picUrl, "drawable",
                        holder.itemView.getContext()
                                .getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResource)
                .into(holder.movies_layout);

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void setCategories(ArrayList<Categories> categories) {
        this.categories = categories;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ConstraintLayout different_movie;
        private ImageView movies_layout;

        public ViewHolder (@NonNull View itemView) {
            super(itemView);

            different_movie = itemView.findViewById(R.id.different_movie);
            movies_layout = itemView.findViewById(R.id.movies_layout);
        }
    }
}