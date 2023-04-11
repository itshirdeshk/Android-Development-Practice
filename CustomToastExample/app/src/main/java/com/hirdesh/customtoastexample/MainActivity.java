package com.hirdesh.customtoastexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnToast = findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Default Toast
                // Toast.makeText(getApplicationContext(), "My First Toast", Toast.LENGTH_SHORT).show();

                // Custom Toast
                Toast toast = new Toast(getApplicationContext());
                View newView = getLayoutInflater().inflate(R.layout.custom_toast_layout, (ViewGroup)findViewById(R.id.viewContainer));
                toast.setView(newView);

                TextView txtMsg = newView.findViewById(R.id.txtMsg);
                txtMsg.setText("Message Sent Successfully !");

                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}

