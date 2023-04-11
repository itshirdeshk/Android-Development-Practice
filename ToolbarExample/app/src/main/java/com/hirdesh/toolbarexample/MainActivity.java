package com.hirdesh.toolbarexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);

        // Step 1 :
        setSupportActionBar(toolbar);

        // Step 2 :
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My Toolbar");
        toolbar.setSubtitle("Sub Title");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.opt_new) {
            Toast.makeText(this, "Create New File", Toast.LENGTH_SHORT).show();
        }

        else if (itemId == R.id.opt_open) {
            Toast.makeText(this, "Open Existing File", Toast.LENGTH_SHORT).show();
        }

        else if (itemId == R.id.opt_save) {
            Toast.makeText(this, "Save File", Toast.LENGTH_SHORT).show();
        }
        
        else {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}