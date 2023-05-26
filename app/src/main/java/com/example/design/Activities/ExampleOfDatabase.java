package com.example.design.Activities;

import static com.example.design.DataExample.FavRoomDatabase.INSTANCE;
import static com.example.design.DataExample.FavRoomDatabase.databaseWriteExecutor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.design.DataExample.Fav;
import com.example.design.DataExample.FavDao;
import com.example.design.DataExample.FavViewModel;
import com.example.design.DatabaseHolder.FavListAdapter;
import com.example.design.UserDatabase.UI.FavNext;
import com.example.design.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ExampleOfDatabase extends AppCompatActivity {

    public static final int new_fav_activity_request_code = 1;
    private FavViewModel eFavViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_of_database);

        FloatingActionButton fab = findViewById(R.id.add_text_button);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(ExampleOfDatabase.this, FavNext.class);
            startActivityForResult(intent, new_fav_activity_request_code);
        });

        RecyclerView recyclerView = findViewById(R.id.dataBase_example_recycler);
        final FavListAdapter adapter = new FavListAdapter(new FavListAdapter.FavDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        eFavViewModel = new ViewModelProvider(this).get(FavViewModel.class);
        eFavViewModel.geteFav().observe(this, adapter::submitList);
    }

    public static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                FavDao dao = INSTANCE.favDao();
                dao.deleteAll();

                Fav fav = new Fav("Hello");
                dao.insert(fav);
                fav = new Fav("World");
                dao.insert(fav);
            });
        }
    };

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==new_fav_activity_request_code || requestCode== RESULT_OK) {
            Fav fav = new Fav(data.getStringExtra(FavNext.extra_reply));
            eFavViewModel.insert(fav);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_SHORT).show();
        }
    }
}