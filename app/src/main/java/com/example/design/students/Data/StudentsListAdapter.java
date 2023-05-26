package com.example.design.students.Data;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.design.students.UI.Students;
import com.example.design.R;

public class StudentsListAdapter extends ListAdapter<Students, StudentsViewHolder> {

    private StdViewModel stdViewModel;
    public StudentsListAdapter(@NonNull DiffUtil.ItemCallback<Students> diffCallback, StdViewModel stdViewModel) {
        super(diffCallback);
        this.stdViewModel = stdViewModel;
    }

    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return StudentsViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, int position) {


        Students currentStudents = getItem(position);
        holder.setStudentId(currentStudents.getStudentId());
        holder.setTextStudentName(currentStudents.getStudentName());
        holder.setTextStudentSurName(currentStudents.getStudentSurname());
        holder.setTextStudentAge(currentStudents.getStudentAge());
        holder.setTextStudentAverage(currentStudents.getStudentAverage());
        holder.setTextStudentConditional(currentStudents.isWorking());
        holder.setTextStudentExcellence(currentStudents.isExcellent());
        holder.setTextCourse(currentStudents.getCourse_name());


        holder.itemView.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("studentId", String.valueOf(currentStudents.getStudentId()));

            Navigation.findNavController(holder.itemView).navigate(R.id.updateStudent, bundle);
        });

        holder.itemView.findViewById(R.id.remove_student_button).setOnClickListener(v-> {
            AlertDialog.Builder removeStudent = new AlertDialog.Builder(holder.itemView.getContext());
            removeStudent.setTitle("Remove " + currentStudents.getStudentName());
            removeStudent.setMessage("Are you sure you want to remove " +  currentStudents.getStudentName() + " student?");
            removeStudent.setPositiveButton("Yes", ((dialog, which) -> {
                stdViewModel.deleteOneStudent(currentStudents);
                Toast.makeText(holder.itemView.getContext(),   currentStudents.getStudentName()+ " removed!", Toast.LENGTH_SHORT).show();
            }));
            removeStudent.setNegativeButton("No", ((dialog, which)-> Toast.makeText(holder.itemView.getContext(), "Nothing to remove", Toast.LENGTH_SHORT).show()));

            removeStudent.show();
        });

    }

    public static class StudentDiff extends DiffUtil.ItemCallback<Students> {

        @Override
        public boolean areItemsTheSame(@NonNull Students oldItem, @NonNull Students newItem) {
            return oldItem==newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Students oldItem, @NonNull Students newItem) {
            return oldItem.getStudentId()==newItem.getStudentId();
        }
    }
}