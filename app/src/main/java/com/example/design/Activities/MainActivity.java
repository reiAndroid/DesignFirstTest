package com.example.design.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.design.R;
import com.example.design.datastore.SaveData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    //Here we declare as global, elements inside our layout
    private EditText txtName, txtLastName, txtEmail, txtPassword, txtRepPassword;
    private TextView txtAcc, txtStarted, txt_user;
    private Button btnLog, button_open_data;
    private ConstraintLayout second_cons, parent_layout;
    private ImageView info_error, info_error_pass, info_error_rep_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SaveData saveData = new SaveData(MainActivity.this);

        init();
        actions();
    }

    public void init(){


        button_open_data = findViewById(R.id.button_open_data);


        button_open_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dataMovie = new Intent(MainActivity.this, MovieDatabaseExample.class);
                startActivity(dataMovie);
            }
        });
        //Here we initialize the elements inside our layout
        txtName = findViewById (R.id.txtName);
        txtLastName = findViewById (R.id.txtLastName);
        txtEmail = findViewById (R.id.txtEmail);
        txtPassword = findViewById (R.id.txtPassword);
        txtRepPassword = findViewById (R.id.txtRepPassword);
        txt_user = findViewById(R.id.txt_user);

        parent_layout = findViewById(R.id.parent_layout);
        second_cons =  findViewById (R.id.second_constraint_layout);

        txtAcc = findViewById (R.id.txtAcc);
        txtStarted = findViewById (R.id.txtStarted);
        btnLog = findViewById(R.id.btnLog);

        info_error = findViewById(R.id.info_error);
        info_error_pass = findViewById(R.id.info_error_pass);
        info_error_rep_pass = findViewById(R.id.info_error_rep_pass);
    }

    //Here we check if the user inputs are regular
    public void checkUserInput(String inputName, String inputLastName, String email, String password, String repPass) {

        if (inputName.equals("")) {
            Toast.makeText(MainActivity.this, "Name can not be empty!", Toast.LENGTH_SHORT).show();
        }
        else if (inputLastName.equals("")) {
            Toast.makeText(this, "Last Name can not be empty!", Toast.LENGTH_SHORT).show();
        }
        else if (email.equals("") || !isValidEmail(email)){
            Toast.makeText(MainActivity.this, "Email is not correct", Toast.LENGTH_SHORT).show();
        }
        else if (password.equals("") || password.length()<8) {
            Toast.makeText(this, "Password must contain 8 Characters", Toast.LENGTH_SHORT).show();
        }
        else if (repPass.equals("") || !repPass.equals(password)){
            Toast.makeText(this, "Password not matching", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(MainActivity.this, GetStarted.class);
            startActivity(intent);
        }

    }

    //Check if the user input in Email field is in accordance with the global rules
    public static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    //Here we create what our design can be and what user can do
    public void actions() {
        txtAcc.setTextColor(Color.WHITE);
        txtAcc.setText("WELCOME");
        txtAcc.setTextSize(28);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            txtAcc.setTextAppearance(R.style.font_get_started);
        }

        txtName.setHint(R.string.first_name);
        txtLastName.setHint(R.string.last_name);
        txtEmail.setHint(R.string.first_email);
        txtPassword.setHint(R.string.first_password);
        txtRepPassword.setHint("Repeat Password");

        txtName.setTextColor(Color.WHITE);
        txtLastName.setTextColor(Color.WHITE);
        txtEmail.setTextColor(Color.WHITE);
        txtPassword.setTextColor(Color.WHITE);
        txtRepPassword.setTextColor(Color.WHITE);

        txtName.setHintTextColor(Color.WHITE);
        txtEmail.setHintTextColor(Color.WHITE);
        txtLastName.setHintTextColor(Color.WHITE);
        txtPassword.setHintTextColor(Color.WHITE);
        txtRepPassword.setHintTextColor(Color.WHITE);

        txtStarted.setTextSize(16);

        btnLog.setAllCaps(false);
        btnLog.setTextSize(16);

        info_error.setVisibility(View.INVISIBLE);
        info_error_pass.setVisibility(View.INVISIBLE);
        info_error_rep_pass.setVisibility(View.INVISIBLE);

        //If the user tap Get Started
        second_cons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkUserInput(txtName.getText().toString(),
                        txtLastName.getText().toString(),
                        txtEmail.getText().toString(),
                        txtPassword.getText().toString(),
                        txtRepPassword.getText().toString());

                SaveData.setString("userName", txtName.getText().toString());
                SaveData.setString("userLastName", txtLastName.getText().toString());
                SaveData.setString("userEmail", txtEmail.getText().toString());
                SaveData.setString("userPassword", txtPassword.getText().toString());
            }
        });

        //If the user click Log In button
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, LogIn.class);
                startActivity(intent);
            }
        });

        //Make an underline text; If the user click the Text
        txt_user.setPaintFlags(txt_user.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        txt_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent terms = new Intent(MainActivity.this, ExampleOfDatabase.class);
                startActivity(terms);
            }
        });

        //Create an animation (Color changed) background
        AnimationDrawable animationDrawable = (AnimationDrawable) parent_layout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        AnimationDrawable getStartedAnimation = (AnimationDrawable) second_cons.getBackground();
        getStartedAnimation.setEnterFadeDuration(2500);
        getStartedAnimation.setExitFadeDuration(5000);
        getStartedAnimation.start();
    }
}