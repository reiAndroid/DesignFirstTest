package com.example.design.students.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.design.R;
import com.example.design.students.Data.StdViewModel;
import com.example.design.students.UI.Students;

import java.util.Calendar;

public class AddNewStudent extends Fragment implements AdapterView.OnItemSelectedListener {
    private StdViewModel stdViewModel;
    private Students students;
    private EditText addName, addSurname, addAvg;
    private RadioButton yesButton, noButton;
    private Spinner spinner, courseListSpinner;
    private Button submitButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_new_student, container, false);

        //Database initialize
        students = new Students();
        stdViewModel = new ViewModelProvider(this).get(StdViewModel.class);


        //Initialize elements
        addName = view.findViewById(R.id.addName);
        addSurname = view.findViewById(R.id.addSurname);
        addAvg = view.findViewById(R.id.addAvg);

        yesButton = view.findViewById(R.id.yesButton);
        noButton = view.findViewById(R.id.noButton);
        submitButton = view.findViewById(R.id.submitButton);


        //Spinner for generating age
        spinner = view.findViewById(R.id.spinner);
        Integer[] years = new Integer[] {1985,1986,1987,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004,2005};
        ArrayAdapter<Integer> spinnerAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, years);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);


        //Spinner for generating courses
        courseListSpinner = view.findViewById(R.id.coursesList);
        String[] courses = new String[] {"English", "Math", "Database", "Data Structure", "Physics", "Biology", "Python", "Java", "Algorithms"};
        ArrayAdapter<String> courseSpinnerAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, courses);
        courseListSpinner.setAdapter(courseSpinnerAdapter);
        courseListSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                students.course_name = courseListSpinner.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //TODO: Change body
            }
        });


        //Call the method
        addStudentInDatabase(view);


        return view;
    }

    //A function to add items to database
    private void addStudentInDatabase(View view) {

        submitButton.setOnClickListener(v -> {

            if (TextUtils.isEmpty(addName.getText()) || TextUtils.isEmpty(addSurname.getText()) || TextUtils.isEmpty(addAvg.getText())) {
                Toast.makeText(getContext(), "Nothing to submit, please check again!", Toast.LENGTH_SHORT).show();
                requireActivity().getSupportFragmentManager().popBackStack();
            } else {
                students.studentName = addName.getText().toString();
                students.studentSurname = addSurname.getText().toString();
                checkExcellence();
                isButtonChecked();
                stdViewModel.addStudent(students);
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }


    //A function to check if the user choose one of the button
    private void isButtonChecked() {
        if (yesButton.isChecked()) {
            students.working = true;
        } else if (noButton.isChecked()) {
            students.working = false;
        } else {
            Toast.makeText(getContext(), "Fulfill all fields", Toast.LENGTH_SHORT).show();
        }
    }

    //A function to check the excellence by user input
    private void checkExcellence() {
        students.excellent = Double.parseDouble(addAvg.getText().toString()) >= 9.5;
        students.studentAverage = Double.parseDouble(addAvg.getText().toString());
    }


    //Spinner onItemSelectedListener methods
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //Calculate the age of the user
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        students.studentAge = currentYear - Integer.parseInt(spinner.getItemAtPosition(position).toString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //TODO: Change body
    }

}