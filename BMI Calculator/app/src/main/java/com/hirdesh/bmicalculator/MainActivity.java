package com.hirdesh.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hirdesh.bmicalculator.R.color;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        EditText weight, heightFt, heightInch;
        Button btnCalculate;
        LinearLayout linearLayout;

        txtResult = findViewById(R.id.result);
        weight = findViewById(R.id.weight);
        heightFt = findViewById(R.id.heightFt);
        heightInch = findViewById(R.id.heightInch);
        btnCalculate = findViewById(R.id.btn_Calculate);
        linearLayout = findViewById(R.id.lLayout);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(weight.getText().toString());
                int ft = Integer.parseInt(heightFt.getText().toString());
                int in = Integer.parseInt(heightInch.getText().toString());

                int totalIn = ft * 12 + in;
                double totalCm = totalIn * 2.53;
                double totalM = totalCm / 100;
                double bmi = wt / (totalM * totalM);

                if (bmi > 25) {
                    txtResult.setText("You are Overweight");
                    linearLayout.setBackgroundColor(getResources().getColor(color.red));

                }

                else if (bmi < 18) {
                    txtResult.setText("You are Underweight");
                    linearLayout.setBackgroundColor(getResources().getColor(color.yellow));
                }

                else {
                    txtResult.setText("You are Healthy");
                    linearLayout.setBackgroundColor(getResources().getColor(color.green));
                }
            }
        });
    }
}