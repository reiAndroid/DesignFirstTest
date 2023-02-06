package com.example.design.DatabaseHolder;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.design.DataExample.Fav;

public class FavListAdapter extends ListAdapter<Fav, FavViewHolder> {
    public FavListAdapter(@NonNull DiffUtil.ItemCallback<Fav> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public FavViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return FavViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder( FavViewHolder holder, int position) {
        Fav current = getItem(position);
        holder.bind(current.getFav());
    }

    public static class FavDiff extends DiffUtil.ItemCallback<Fav> {
        @Override
        public boolean areItemsTheSame(@NonNull Fav oldItem, @NonNull Fav newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Fav oldItem, @NonNull Fav newItem) {
            return oldItem.getFav().equals(newItem.getFav());
        }
    }
}