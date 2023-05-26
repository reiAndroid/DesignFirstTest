package com.example.design.students.Data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.design.R;

public class StudentsViewHolder extends RecyclerView.ViewHolder{

    private TextView textStudentName, textStudentSurName, textStudentAge, textStudentAverage, textStudentConditional, textStudentExcellence, textCourse, studentId;
    private ImageButton removeStudent;

    public StudentsViewHolder(@NonNull View itemView) {
        super(itemView);

        textStudentName = itemView.findViewById(R.id.textStudentName);
        textStudentSurName = itemView.findViewById(R.id.textStudentSurName);
        textStudentAge = itemView.findViewById(R.id.textStudentAge);
        textStudentAverage = itemView.findViewById(R.id.textStudentAverage);
        textStudentConditional = itemView.findViewById(R.id.textStudentConditional);
        textStudentExcellence = itemView.findViewById(R.id.textStudentExcellence);
        studentId = itemView.findViewById(R.id.studentId);
        removeStudent = itemView.findViewById(R.id.remove_student_button);
        textCourse = itemView.findViewById(R.id.textCourse);
    }

    public void setStudentId(int id) {
        studentId.setText(String.valueOf(id));
    }

    public void setTextStudentName(String studentName) {
        textStudentName.setText(studentName);
    }

    public void setTextStudentSurName(String studentSurName) {
        textStudentSurName.setText(studentSurName);
    }

    public void setTextStudentAge(int studentAge) {
        textStudentAge.setText(String.valueOf(studentAge));
    }

    public void setTextStudentAverage(double studentAverage) {
        textStudentAverage.setText(String.valueOf(studentAverage));
    }

    public void setTextStudentConditional(boolean studentWorking) {

        if (studentWorking) {
            textStudentConditional.setText("Working");
        } else {
            textStudentConditional.setText("Not working");
        }
    }

    public void setTextStudentExcellence(boolean studentExcellence) {

        if (studentExcellence) {
            textStudentExcellence.setText("Excellent Student");
        } else {
            textStudentExcellence.setText("Not excellent student");
        }
    }

    //Latest Change
    public void setTextCourse(String courseName) {
        textCourse.setText(courseName);
    }

    static StudentsViewHolder create (ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_layout_list, parent, false);
        return new StudentsViewHolder(view);
    }
}