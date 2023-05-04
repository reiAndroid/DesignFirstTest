package com.example.design.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.design.R;
import com.example.design.ViewModel.CourseViewModel;
import com.example.design.ViewModel.StdViewModel;
import com.example.design.studentAdapter.StudentsListAdapter;

public class AddStudents extends Fragment {

    private StdViewModel stdViewModel;
    private CourseViewModel courseViewModel;
    private StudentsListAdapter listAdapter;
    private RecyclerView stdRecyclerView;
    private Button addNewStudentButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_students, container, false);


        Toolbar toolbar = (Toolbar) view.findViewById(R.id.studentToolbar);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);

        //Initialize UI elements
        stdRecyclerView = view.findViewById(R.id.stdRecyclerView);
        addNewStudentButton = view.findViewById(R.id.addNewStudentButton);

        //Read the data
        stdViewModel = new ViewModelProvider(this).get(StdViewModel.class);
        courseViewModel = new ViewModelProvider(this).get(CourseViewModel.class);

        //Set adapter to recyclerview
        listAdapter = new StudentsListAdapter(new StudentsListAdapter.StudentDiff(), courseViewModel);
        stdRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        stdRecyclerView.setAdapter(listAdapter);

        //Show the data
        stdViewModel.getStudents().observe(getViewLifecycleOwner(), listAdapter::submitList);

        ImageButton imageButton = (ImageButton) view.findViewById(R.id.deleteAllStudents);
        imageButton.setOnClickListener(v -> {
            AlertDialog.Builder delete = new AlertDialog.Builder(requireContext());
            delete.setTitle("Delete All");
            delete.setMessage("Are you sure you want to delete all students?");

            delete.setPositiveButton("Yes", (dialog, which) -> stdViewModel.deleteAllStudents());
            delete.setNegativeButton("No", (dialog, which) ->
                    Toast.makeText(getContext(), "Nothing deleted!", Toast.LENGTH_SHORT).show());

            delete.show();
        });


        //Delete an item
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                //TODO: Delete item
            }
        }).attachToRecyclerView(stdRecyclerView);

        //Navigate to another fragment
        addNewStudentButton.setOnClickListener(view1-> Navigation.findNavController(view).navigate(R.id.addNewStudent));

        return view;
    }

}