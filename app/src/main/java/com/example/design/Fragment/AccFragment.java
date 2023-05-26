package com.example.design.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.design.Adapter.AccountTextAdapter;
import com.example.design.R;
import com.example.design.UserDatabase.Model.Text;

import java.util.ArrayList;
import java.util.Objects;

public class AccFragment extends Fragment {

    private RecyclerView information_account_status;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_acc, container, false);

      information_account_status = view.findViewById(R.id.information_account_status);


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



        textInformations();
        return view;

    }

    public void textInformations(){
        AccountTextAdapter text_adapter = new AccountTextAdapter(this.getContext());

        information_account_status.setAdapter(text_adapter);
        information_account_status.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));

        ArrayList<Text> texts = new ArrayList<>();

        texts.add(new Text("Personal Information", 1000));
        texts.add(new Text("Account Status", 1001));
        texts.add(new Text("Notification", 1002));
        texts.add(new Text("Language", 1003));
        texts.add(new Text("Captions", 1004));
        texts.add(new Text("About", 1005));

        text_adapter.setTexts(texts);
    }
}