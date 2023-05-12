package com.example.design.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.design.R;
import com.example.design.ViewModel.StdViewModel;
import com.example.design.students.Students;

public class ChangeAttributes extends Fragment {

    private EditText edit_text_change;
    private StdViewModel stdViewModel;
    private Students students;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change_attributes, container, false);

        ImageButton imageButton_back = view.findViewById(R.id.imageButton_back);
        TextView title_text = view.findViewById(R.id.title_text);
        edit_text_change = view.findViewById(R.id.edit_text_change);
        Button change_attribute_button = view.findViewById(R.id.change_attribute_button);


        stdViewModel = new ViewModelProvider(this).get(StdViewModel.class);
        if(getArguments() != null) {
            int getData = getArguments().getInt("studentsId");
            students = stdViewModel.getStudentsById(getData);
        }

        //Get Data and change content
        if (getArguments().getBoolean("name")) {
            edit_text_change.setText(students.studentName);
            title_text.setText(R.string.changeTitleName);
            change_attribute_button.setOnClickListener(v-> {
                updateName();
                getBack();
            });
        } else if (getArguments().getBoolean("surname")) {
            edit_text_change.setText(students.studentSurname);
            title_text.setText(R.string.changeTitleSurname);
            change_attribute_button.setOnClickListener(v-> {
                updateSurname();
                getBack();
            });
        } else if (getArguments().getBoolean("age")) {
            edit_text_change.setText(String.valueOf(students.studentAge));
            edit_text_change.setInputType(InputType.TYPE_CLASS_NUMBER);
            title_text.setText(R.string.changeTitleAge);
            change_attribute_button.setOnClickListener(v -> {
                updateAge();
                getBack();
            });
        } else if (getArguments().getBoolean("average")) {
            edit_text_change.setText(String.valueOf(students.studentAverage));
            edit_text_change.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
            title_text.setText(R.string.changeTitleAverage);
            change_attribute_button.setOnClickListener(v -> {
                updateAverage();
                getBack();
            });
        } else if (getArguments().getBoolean("courseName")) {
            edit_text_change.setText(String.valueOf(students.course_name));
            title_text.setText(R.string.changeTitleCourse);
            change_attribute_button.setOnClickListener(v -> {
                updateCourse();
                getBack();
            });
        }


        //If the back up-button is clicked
        imageButton_back.setOnClickListener(v-> {
            Toast.makeText(getContext(), "Nothing edited", Toast.LENGTH_SHORT).show();
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        return view;
    }

    //A function to show a message and to go back in other fragment
    private void getBack() {
        Toast.makeText(getContext(), "Tap twice to go back", Toast.LENGTH_SHORT).show();
        requireActivity().getSupportFragmentManager().popBackStack();
    }


    /*
    Functions to update in Database the object (Students) 105-134
     */

    //To update only the Name of the Student
    private void updateName() {
        String newName = edit_text_change.getText().toString();

        students.setStudentName(newName);
        stdViewModel.updateStudent(students);
    }

    private void updateSurname() {
        String newSurname = edit_text_change.getText().toString();

        students.setStudentSurname(newSurname);
        stdViewModel.updateStudent(students);
    }

    private void updateAge() {
        int newAge = Integer.parseInt(edit_text_change.getText().toString());

        students.setStudentAge(newAge);
        stdViewModel.updateStudent(students);
    }

    private void updateAverage() {
        double newAverage = Double.parseDouble(edit_text_change.getText().toString());

        students.setStudentAverage(newAverage);
        students.setExcellent(newAverage >= 9.5);
        stdViewModel.updateStudent(students);
    }

    private void updateCourse() {
        String newCourse = edit_text_change.getText().toString();

        students.setCourse_name(newCourse);
        stdViewModel.updateStudent(students);
    }
}