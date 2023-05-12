package com.example.design.Fragment;


import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.design.R;
import com.example.design.ViewModel.StdViewModel;
import com.example.design.students.Students;

public class UpdateStudent extends Fragment {
    private String studentId;
    private Students students;
    private TextView text_student_name_before_edit;
    private TextView text_student_Surname_before_edit;
    private TextView text_student_age_before_edit;
    private TextView text_student_avg_before_edit;
    private TextView text_student_excellent_before_edit;
    private TextView text_course_name_before_edit;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_update_student, container, false);

        //Initializing elements
        text_student_name_before_edit = view.findViewById(R.id.text_student_name_before_edit);
        text_student_Surname_before_edit = view.findViewById(R.id.text_student_Surname_before_edit);
        text_student_age_before_edit = view.findViewById(R.id.text_student_age_before_edit);
        text_student_avg_before_edit = view.findViewById(R.id.text_student_avg_before_edit);
        TextView text_student_working_before_edit = view.findViewById(R.id.text_student_working_before_edit);
        text_student_excellent_before_edit = view.findViewById(R.id.text_student_excellent_before_edit);
        text_course_name_before_edit = view.findViewById(R.id.text_course_name_before_edit);
        LinearLayout credentialsName = view.findViewById(R.id.credentialsName);
        LinearLayout credentials_Surname = view.findViewById(R.id.credentials_Surname);
        LinearLayout credentials_Age = view.findViewById(R.id.credentials_Age);
        LinearLayout conditionals_Average = view.findViewById(R.id.conditionals_Average);
        LinearLayout conditionals_Courses = view.findViewById(R.id.conditionals_Courses);
        LinearLayout conditionals_working = view.findViewById(R.id.conditionals_working);
        LinearLayout conditionals_excellent = view.findViewById(R.id.conditionals_excellent);


        //Get data with args
        if (getArguments() != null) {
            studentId = getArguments().getString("studentId");
        }
        StdViewModel stdViewModelUpdate = new ViewModelProvider(this).get(StdViewModel.class);
        students = stdViewModelUpdate.getStudentsById(Integer.parseInt(studentId));

        //Set the attributes of the object to the view
        text_student_name_before_edit.setText(students.studentName);
        text_student_Surname_before_edit.setText(students.studentSurname);
        text_student_age_before_edit.setText(String.valueOf(students.studentAge));
        text_student_avg_before_edit.setText(String.valueOf(students.studentAverage));

        if (students.working) {
            text_student_working_before_edit.setText(R.string.workingCondition);
        } else {
            text_student_working_before_edit.setText(R.string.NotWorkingCondition);
        }

        if (students.excellent) {
            text_student_excellent_before_edit.setText(R.string.excellentStudent);
        } else {
            text_student_excellent_before_edit.setText(R.string.NotExcellentStudent);
        }

        text_course_name_before_edit.setText(students.course_name);


        //onClick for fields
        credentialsName.setOnClickListener(v -> sendBundle("isName"));

        credentials_Surname.setOnClickListener(v -> sendBundle("isSurname"));

        credentials_Age.setOnClickListener(v -> sendBundle("isAge"));

        conditionals_Average.setOnClickListener(v -> sendBundle("isAverage"));

        conditionals_Courses.setOnClickListener(v -> sendBundle("isCourse"));


        //onClick for not changing fields
        conditionals_working.setOnClickListener(v -> showMessage());
        conditionals_excellent.setOnClickListener(v -> showMessage());

        return view;
    }

    private void sendBundle(String studentData){
        Bundle result = new Bundle();
        result.putInt("studentsId", students.getStudentId());

        switch (studentData) {
            case "isName":
                result.putBoolean("name", true);
                break;
            case "isSurname":
                result.putBoolean("surname", true);
                break;
            case "isAge":
                result.putBoolean("age", true);
                break;
            case "isAverage":
                result.putBoolean("average", true);
                break;
            case "isCourse":
                result.putBoolean("courseName", true);
                break;
        }

        Navigation.findNavController(view).navigate(R.id.changeAttributes, result);
    }

    //Create a Toast message, for the field that can not be edited
    private void showMessage() {
        Toast.makeText(getContext(), "This field can not be edited!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        text_student_name_before_edit.setText(students.getStudentName());
        text_student_Surname_before_edit.setText(students.getStudentSurname());
        text_student_age_before_edit.setText(String.valueOf(students.getStudentAge()));
        text_student_avg_before_edit.setText(String.valueOf(students.getStudentAverage()));

        if (Integer.parseInt(text_student_avg_before_edit.getText().toString()) >= 9.5) {
            text_student_excellent_before_edit.setText(R.string.excellentStudent);
        } else {
            text_student_excellent_before_edit.setText(R.string.NotExcellentStudent);
        }

        text_course_name_before_edit.setText(students.getCourse_name());

    }
}