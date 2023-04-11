package com.hirdesh.bottomnavigationexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnView = findViewById(R.id.btView);
        bnView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.nav_home) {
                    loadFragment(new Home_Fragment());
                }

                else if (id == R.id.nav_ContactUs) {
                    loadFragment(new Home_Fragment());
                }

                else if (id == R.id.nav_Search){
                    loadFragment(new Home_Fragment());
                }

                else if (id == R.id.nav_myProfile) {
                    loadFragment(new Home_Fragment());
                }

                else {
                    loadFragment(new Home_Fragment());
                }
                return true;
            }
        });
        bnView.setSelectedItemId(R.id.nav_myProfile);
    }

    public void loadFragment (Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

}