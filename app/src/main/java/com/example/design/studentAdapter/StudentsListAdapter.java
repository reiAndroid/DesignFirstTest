package com.example.design.studentAdapter;


import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.example.design.ViewModel.CourseViewModel;
import com.example.design.students.Students;
import com.example.design.R;

public class StudentsListAdapter extends ListAdapter<Students, StudentsViewHolder> {
    private CourseViewModel courseViewModel;
    public StudentsListAdapter(@NonNull DiffUtil.ItemCallback<Students> diffCallback, CourseViewModel courseViewModel) {
        super(diffCallback);
        this.courseViewModel = courseViewModel;
    }

    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return StudentsViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, int position) {


        Students currentStudents = getItem(position);
        holder.setTextStudentName(currentStudents.getStudentName());
        holder.setTextStudentSurName(currentStudents.getStudentSurname());
        holder.setTextStudentAge(currentStudents.getStudentAge());
        holder.setTextStudentAverage(currentStudents.getStudentAverage());
        holder.setTextStudentConditional(currentStudents.isWorking());
        holder.setTextStudentExcellence(currentStudents.isExcellent());
        //Latest change
        holder.setTextCourse(currentStudents.getCourse_name());


        holder.itemView.setOnClickListener(v -> {
            currentStudents.studentId = currentStudents.getStudentId();
            currentStudents.studentName = currentStudents.getStudentName();
            currentStudents.studentSurname = currentStudents.getStudentSurname();
            currentStudents.studentAge = currentStudents.getStudentAge();
            currentStudents.studentAverage = currentStudents.getStudentAverage();
            currentStudents.working = currentStudents.isWorking();
            currentStudents.excellent = currentStudents.isExcellent();
            Navigation.findNavController(holder.itemView).navigate(R.id.updateStudent);
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