package com.example.design.studentAdapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.example.design.ViewModel.CourseViewModel;
import com.example.design.students.Students;
import com.example.design.R;

public class StudentsListAdapter extends ListAdapter<Students, StudentsViewHolder> {
    public StudentsListAdapter(@NonNull DiffUtil.ItemCallback<Students> diffCallback, CourseViewModel courseViewModel) {
        super(diffCallback);
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


        holder.itemView.findViewById(R.id.textCourse).setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("studentId", String.valueOf(currentStudents.getStudentId()));

            Navigation.findNavController(holder.itemView).navigate(R.id.updateStudent, bundle);
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