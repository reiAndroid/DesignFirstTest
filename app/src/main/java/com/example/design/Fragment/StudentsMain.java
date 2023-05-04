package com.example.design.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.design.R;

public class StudentsMain extends Fragment {

    private Button register;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewStudent = inflater.inflate(R.layout.fragment_students_main, container, false);

        register = viewStudent.findViewById(R.id.addStudentButton);

        register.setOnClickListener(v -> Navigation.findNavController(viewStudent).navigate(R.id.addStudents));

        return viewStudent;
    }
}