package com.example.design.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.design.R;

public class LogIn extends AppCompatActivity {

    private ConstraintLayout log_in_activity;
    private TextView first_text_log, txt_privacy;
    private LinearLayout elements_layout;
    private ImageView eMail_error, pass_error;
    private EditText logIn_email, logIn_pass;
    private Button logIn_btn;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        initialize();
        action();
    }

    public void initialize(){

        log_in_activity = findViewById(R.id.log_in_activity);

        first_text_log = findViewById(R.id.first_text_log);
        txt_privacy = findViewById(R.id.txt_privacy);

        elements_layout = findViewById(R.id.elements_layout);

        eMail_error = findViewById(R.id.eMail_error);
        pass_error = findViewById(R.id.pass_error);

        logIn_email = findViewById(R.id.logIn_email);
        logIn_pass = findViewById(R.id.logIn_pass);
        logIn_btn = findViewById(R.id.logIn_btn);
    }

    public void action(){

        txt_privacy.setTextColor(Color.DKGRAY);

        logIn_email.setHintTextColor(Color.WHITE);
        logIn_pass.setHintTextColor(Color.WHITE);
        logIn_email.setTextColor(Color.WHITE);
        logIn_pass.setTextColor(Color.WHITE);

        logIn_btn.setTextSize(16);
        logIn_btn.setAllCaps(false);

        eMail_error.setVisibility(View.INVISIBLE);
        pass_error.setVisibility(View.INVISIBLE);

        logIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (logIn_email.getText().length() == 0 && logIn_pass.getText().toString().equals("")) {
                   eMail_error.setVisibility(View.VISIBLE);
                   pass_error.setVisibility(View.VISIBLE);
                }
                else if (logIn_email.getText().length() == 0 && !logIn_pass.getText().toString().equals("")){
                    eMail_error.setVisibility(View.VISIBLE);
                }
                else if (logIn_email.getText().length() !=0 && logIn_pass.getText().toString().equals("")) {
                    pass_error.setVisibility(View.VISIBLE);
                } else {
                    Intent intent = new Intent (LogIn.this, GetStarted.class);
                    startActivity(intent);
                }

                sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();

                myEdit.putString("email", logIn_email.getText().toString());
                myEdit.putString("password", logIn_pass.getText().toString());

                myEdit.apply();
            }
        });

        txt_privacy.setTextColor(Color.WHITE);
        txt_privacy.setPaintFlags(txt_privacy.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        txt_privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent privacy = new Intent(LogIn.this, TermsAndPrivacy.class);
                startActivity(privacy);
            }
        });

        AnimationDrawable anLogIn = (AnimationDrawable) log_in_activity.getBackground();
        anLogIn.setEnterFadeDuration(2500);
        anLogIn.setExitFadeDuration(5000);
        anLogIn.start();
    }
}