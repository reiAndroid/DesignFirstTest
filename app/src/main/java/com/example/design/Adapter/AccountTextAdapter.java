package com.example.design.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design.R;
import com.example.design.UserDatabase.Model.Text;

import java.util.ArrayList;

public class AccountTextAdapter extends RecyclerView.Adapter<AccountTextAdapter.ViewHolder> {

    ArrayList<Text> texts = new ArrayList<>();

    Context textContext;

    public AccountTextAdapter(Context textContext) {
        this.textContext = textContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_acc_status_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text_information.setText(texts.get(position).getText());

    }


    @Override
    public int getItemCount() {
        return texts.size();
    }

    public void setTexts(ArrayList<Text> texts) {
        this.texts = texts;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout text_information_layout;
        private TextView text_information;
        public ViewHolder (@NonNull View itemView) {
            super(itemView);

           text_information_layout = itemView.findViewById(R.id.text_information_layout);
           text_information = itemView.findViewById(R.id.text_information);
        }
    }
}