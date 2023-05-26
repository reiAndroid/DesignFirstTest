package com.example.design.UserDatabase.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.example.design.R;

public class FavNext extends AppCompatActivity {

    public static final String extra_reply = "com.example.android.favListSql.REPLY";

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_next);

        editText = findViewById(R.id.fav_edit_text);

        final Button button = findViewById(R.id.button_save_fav);

        button.setOnClickListener(v -> {
            Intent replyIntent = new Intent();
            if(TextUtils.isEmpty(editText.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String fav = editText.getText().toString();
                replyIntent.putExtra(extra_reply, fav);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });

    }
}