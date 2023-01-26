package com.example.design.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.design.R;
import java.util.Objects;

public class AccFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_acc, container, false);

        Button openFirstFragment = view.findViewById(R.id.openFirstFragment);
        Button secondFragment = view.findViewById(R.id.secondFragment);

        final String[] appBarTitle = {""};

        openFirstFragment.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.personal_information_const);

            appBarTitle[0] = "Personal Information";
            Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle(appBarTitle[0]);
            Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);

        });

        secondFragment.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.acc_status_frag);
            appBarTitle[0] = "Status";
            Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle(appBarTitle[0]);
        });

        return view;

    }
}