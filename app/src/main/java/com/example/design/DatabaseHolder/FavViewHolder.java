package com.example.design.DatabaseHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design.R;

public class FavViewHolder extends RecyclerView.ViewHolder {

    private final TextView favItemView;

    public FavViewHolder(@NonNull View itemView) {
        super(itemView);

        favItemView = itemView.findViewById(R.id.text_database_example);
    }

    public void bind(String text) {
        favItemView.setText(text);
    }

    static FavViewHolder create (ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.database_text_example, parent, false);
        return new FavViewHolder(view);
    }
}