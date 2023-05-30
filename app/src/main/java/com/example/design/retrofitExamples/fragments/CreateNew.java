package com.example.design.retrofitExamples.fragments;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import com.example.design.retrofitExamples.Data.RetrofitViewModelTest;
import com.example.design.retrofitExamples.ui.posts.Posts;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.example.design.R;

public class CreateNew extends BottomSheetDialogFragment {

    public static final String TAG = "CreateNewBottomDialog";
    private EditText edit_text_change_user_id, edit_text_change_title, edit_text_change_body;
    private Button change_post_button;

    private Posts newPost;

    private RetrofitViewModelTest viewModelTest;


    public static CreateNew newInstance() {
        return new CreateNew();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.create_new_bottom_fragment, container, false);


        newPost = new Posts();
        viewModelTest = new ViewModelProvider(this).get(RetrofitViewModelTest.class);

        edit_text_change_user_id = view.findViewById(R.id.edit_text_change_user_id);
        edit_text_change_title = view.findViewById(R.id.edit_text_change_title);
        edit_text_change_body = view.findViewById(R.id.edit_text_change_body);
        change_post_button = view.findViewById(R.id.change_post_button);

        addToDb();

        return view;
    }

    private void addToDb() {

        change_post_button.setOnClickListener(v-> {

            if (TextUtils.isEmpty(edit_text_change_user_id.getText()) && TextUtils.isEmpty(edit_text_change_title.getText())
                        && TextUtils.isEmpty(edit_text_change_body.getText())) {
                Toast.makeText(getContext(), "Nothing to enter!", Toast.LENGTH_SHORT).show();
                requireActivity().getSupportFragmentManager().popBackStack();
            } else {
                newPost.userId = Integer.parseInt(edit_text_change_user_id.getText().toString());
                newPost.title = edit_text_change_title.getText().toString();
                newPost.body = edit_text_change_body.getText().toString();
                viewModelTest.insertOnePostInDb(newPost);
                Toast.makeText(getContext(), "New post entered!", Toast.LENGTH_SHORT).show();
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }
}