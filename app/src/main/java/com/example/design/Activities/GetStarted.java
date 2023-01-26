package com.example.design.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.example.design.R;
import com.example.design.datastore.SaveData;
import com.google.android.material.navigation.NavigationView;


public class GetStarted extends AppCompatActivity {

    private DrawerLayout menu_layout;
    private NavigationView navigation_view;
    private AppBarConfiguration mAppBarConfiguration;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_strated);

        //Here we create the statements and elements for NavigationView and Toolbar
        menu_layout = findViewById(R.id.menu_layout);
        setSupportActionBar(menu_layout.findViewById(R.id.toolbar));

        //Declaring the SharedPrefs
        SaveData saveData = new SaveData(GetStarted.this);

        //Here we create the conditions for SharedPrefs and get the context from the user and implements them to this activity
        navigation_view = findViewById(R.id.navigation_view);
        View header = navigation_view.getHeaderView(0);
        TextView userName = header.findViewById(R.id.username);
        TextView userEmail = header.findViewById(R.id.user_email);

        //Here we use the methods of SaveData Class to get the SharedPrefs
        userName.setText(SaveData.getString("userName"));
        userEmail.setText(SaveData.getString("userEmail"));

        //Here we set the configuration for NavigationView work
        navigation_view.setCheckedItem(R.id.home_nav);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                 R.id.home_nav, R.id.category_id, R.id.favorites, R.id.account)
                .setOpenableLayout(menu_layout)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_container1);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigation_view, navController);

    }

    @Override
    public void onBackPressed() {
        if (menu_layout.isDrawerOpen(GravityCompat.START)){
            menu_layout.closeDrawer(GravityCompat.START);
        }
        else {
            navigation_view.setCheckedItem(R.id.home_nav);
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer_layout, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_container1);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}