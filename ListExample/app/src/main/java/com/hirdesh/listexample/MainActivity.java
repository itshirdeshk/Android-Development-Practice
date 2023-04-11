package com.hirdesh.listexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Spinner spinner;
    AutoCompleteTextView autoTextView;

    ArrayList<String> arrNames = new ArrayList<>();
    ArrayList<String> arrIDs = new ArrayList<>();
    ArrayList<String> arrLanguages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        autoTextView = findViewById(R.id.autoTextView);

        // ListView

        arrNames.add("Hirdesh");
        arrNames.add("Madhav");
        arrNames.add("Yash");
        arrNames.add("Pranjal");
        arrNames.add("Pranjul");
        arrNames.add("Hirdesh");
        arrNames.add("Madhav");
        arrNames.add("Yash");
        arrNames.add("Pranjal");
        arrNames.add("Pranjul");
        arrNames.add("Hirdesh");
        arrNames.add("Madhav");
        arrNames.add("Yash");
        arrNames.add("Pranjal");
        arrNames.add("Pranjul");
        arrNames.add("Hirdesh");
        arrNames.add("Madhav");
        arrNames.add("Yash");
        arrNames.add("Pranjal");
        arrNames.add("Pranjul");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    Toast.makeText(MainActivity.this, "Clicked First Item", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Spinner

        arrIDs.add("Aadhar Card");
        arrIDs.add("PAN Card");
        arrIDs.add("Voter ID Card");
        arrIDs.add("Passport");
        arrIDs.add("Driving License");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, arrIDs);
        spinner.setAdapter(spinnerAdapter);

        // AutoComplete TextView
        arrLanguages.add("C");
        arrLanguages.add("C++");
        arrLanguages.add("Java");
        arrLanguages.add("Kotlin");
        arrLanguages.add("PHP");
        arrLanguages.add("Python");

        ArrayAdapter<String> autoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrLanguages);
        autoTextView.setAdapter(autoAdapter);
        autoTextView.setThreshold(2);
    }
}