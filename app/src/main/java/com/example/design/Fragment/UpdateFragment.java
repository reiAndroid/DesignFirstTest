package com.example.design.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.design.R;
import com.example.design.datastore.SaveData;

public class UpdateFragment extends Fragment {

    private EditText updateMovieNameEdit, updateMovieRateEdit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_update, container, false);

        //Initialize of User Elements
        updateMovieNameEdit = view.findViewById(R.id.updateMovieNameEdit);
        updateMovieRateEdit = view.findViewById(R.id.updateMovieRateEdit);
        Button cancelUpdate = view.findViewById(R.id.cancelUpdate);
        Button updateMovieButton = view.findViewById(R.id.updateMovieButton);

        //Show Data
        updateMovieNameEdit.setText(SaveData.getString("movieName"));
        updateMovieRateEdit.setText(String.valueOf(SaveData.getInt("movieRate")));

        //onClick (cancel)
        cancelUpdate.setOnClickListener(view1-> {
            Toast.makeText(getContext(), "Nothing is Updated!", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(view).navigate(R.id.movieDataExample);
        });

        //onClick (save)
        updateMovieButton.setOnClickListener(view1-> {
            if(TextUtils.isEmpty(updateMovieNameEdit.getText()) || TextUtils.isEmpty(updateMovieRateEdit.getText())) {
                Toast.makeText(getContext(), "Nothing to Update!", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.movieDataExample);
            } else {
                Navigation.findNavController(view).navigate(R.id.movieDataExample);
            }
        });

        return view;
    }
}