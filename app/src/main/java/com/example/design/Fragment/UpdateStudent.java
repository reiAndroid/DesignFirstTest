package com.example.design.Fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.design.R;
import com.example.design.ViewModel.StdViewModel;
import com.example.design.students.Students;

public class UpdateStudent extends Fragment {
    private String studentId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_student, container, false);

        //Initializing elements
        TextView text_student_name_before_edit = view.findViewById(R.id.text_student_name_before_edit);
        TextView text_student_Surname_before_edit = view.findViewById(R.id.text_student_Surname_before_edit);
        TextView text_student_age_before_edit = view.findViewById(R.id.text_student_age_before_edit);
        TextView text_student_avg_before_edit = view.findViewById(R.id.text_student_avg_before_edit);
        TextView text_student_working_before_edit = view.findViewById(R.id.text_student_working_before_edit);
        TextView text_student_excellent_before_edit = view.findViewById(R.id.text_student_excellent_before_edit);
        TextView text_course_avg_before_edit = view.findViewById(R.id.text_course_avg_before_edit);
        LinearLayout credentialsName = view.findViewById(R.id.credentialsName);
        LinearLayout credentials_Surname = view.findViewById(R.id.credentials_Surname);


        //Get data with args
        if (getArguments() != null) {
            studentId = getArguments().getString("studentId");
        }
        StdViewModel stdViewModelUpdate = new ViewModelProvider(this).get(StdViewModel.class);
        Students students = stdViewModelUpdate.getStudentsById(Integer.parseInt(studentId));

        //Set the attributes of the object to the view
        text_student_name_before_edit.setText(students.studentName);
        text_student_Surname_before_edit.setText(students.studentSurname);
        text_student_age_before_edit.setText(String.valueOf(students.studentAge));
        text_student_avg_before_edit.setText(String.valueOf(students.studentAverage));

        if(students.working) {
            text_student_working_before_edit.setText("Working");
        } else {
            text_student_working_before_edit.setText("Not Working");
        }

        if(students.excellent) {
            text_student_excellent_before_edit.setText("You are an excellent student");
        } else {
            text_student_excellent_before_edit.setText("You are not an excellent student");
        }

        text_course_avg_before_edit.setText(students.course_name);


        //Set onClickListener for fields
        credentialsName.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.changeAttributes));
        credentials_Surname.setOnClickListener(v-> Navigation.findNavController(view).navigate(R.id.changeAttributes));

        return view;
    }
}