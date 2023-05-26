package com.example.design.retrofitExamples.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.example.design.R;

public class CreateNew extends BottomSheetDialogFragment {

    public static final String TAG = "CreateNewBottomDialog";
    private EditText edit_text_change_user_id, edit_text_change_title, edit_text_change_body;
    private Button change_post_button;

    public static CreateNew newInstance() {
        return new CreateNew();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.create_new_bottom_fragment, container, false);

        edit_text_change_user_id = view.findViewById(R.id.edit_text_change_user_id);
        edit_text_change_title = view.findViewById(R.id.edit_text_change_title);
        edit_text_change_body = view.findViewById(R.id.edit_text_change_body);
        change_post_button = view.findViewById(R.id.change_post_button);

        return view;
    }
}
