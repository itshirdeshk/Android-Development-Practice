package com.hirdesh.roomdatabaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtTitle, edtAmount;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTitle = findViewById(R.id.edtTitle);
        edtAmount = findViewById(R.id.edtAmount);
        btnAdd = findViewById(R.id.btnAdd);

        DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = edtTitle.getText().toString();
                String amount = edtAmount.getText().toString();

                databaseHelper.expenseDao().addTx(
                        new Expense(title, amount));

                ArrayList<Expense> arrExpense = (ArrayList<Expense>) databaseHelper.expenseDao().getAllExpense();

                for(int i = 0; i < arrExpense.size(); i++) {
                    Log.d("Data", "Title : " + arrExpense.get(i).getTitle() + " Amount : " + arrExpense.get(i).getAmount());
                }

            }
        });
    }
}