package com.hirdesh.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerContactAdapter adapter;
    FloatingActionButton btnOpenDialog;

    ArrayList<ContactModel> arrContacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerContact = findViewById(R.id.recyclerContact);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_layout);

                EditText editName = dialog.findViewById(R.id.editName);
                EditText editNumber = dialog.findViewById(R.id.editNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "", number = "";
                        if (!editName.getText().toString().equals("")) {
                            name = editName.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please Enter a valid Contact Name!", Toast.LENGTH_SHORT).show();
                        }

                        if (!editName.getText().toString().equals("")) {
                            number = editNumber.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please Enter a valid Contact Number!", Toast.LENGTH_SHORT).show();
                        }

                        arrContacts.add(new ContactModel(R.drawable.avatar1, name, number));
                        adapter.notifyItemChanged(arrContacts.size() - 1);

                        recyclerContact.scrollToPosition(arrContacts.size() - 1);

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
        recyclerContact.setLayoutManager(new LinearLayoutManager(this));

        arrContacts.add(new ContactModel(R.drawable.avatar1, "Hirdesh Khandelwal", "7252995449"));
        arrContacts.add(new ContactModel(R.drawable.avatar2, "Madhav Solanki", "7252995449"));
        arrContacts.add(new ContactModel(R.drawable.avatar3, "Yash Tiwari", "7252995449"));
        arrContacts.add(new ContactModel(R.drawable.avatar4, "Pranjal Chaturvedi", "7252995449"));
        arrContacts.add(new ContactModel(R.drawable.avatar5, "Pranjul", "7252995449"));

        arrContacts.add(new ContactModel(R.drawable.avatar1, "Hirdesh Khandelwal", "7252995449"));
        arrContacts.add(new ContactModel(R.drawable.avatar2, "Madhav Solanki", "7252995449"));
        arrContacts.add(new ContactModel(R.drawable.avatar3, "Yash Tiwari", "7252995449"));
        arrContacts.add(new ContactModel(R.drawable.avatar4, "Pranjal Chaturvedi", "7252995449"));
        arrContacts.add(new ContactModel(R.drawable.avatar5, "Pranjul", "7252995449"));

        arrContacts.add(new ContactModel(R.drawable.avatar1, "Hirdesh Khandelwal", "7252995449"));
        arrContacts.add(new ContactModel(R.drawable.avatar2, "Madhav Solanki", "7252995449"));
        arrContacts.add(new ContactModel(R.drawable.avatar3, "Yash Tiwari", "7252995449"));
        arrContacts.add(new ContactModel(R.drawable.avatar4, "Pranjal Chaturvedi", "7252995449"));
        arrContacts.add(new ContactModel(R.drawable.avatar5, "Pranjul", "7252995449"));

        arrContacts.add(new ContactModel(R.drawable.avatar1, "Hirdesh Khandelwal", "7252995449"));
        arrContacts.add(new ContactModel(R.drawable.avatar2, "Madhav Solanki", "7252995449"));
        arrContacts.add(new ContactModel(R.drawable.avatar3, "Yash Tiwari", "7252995449"));
        arrContacts.add(new ContactModel(R.drawable.avatar4, "Pranjal Chaturvedi", "7252995449"));
        arrContacts.add(new ContactModel(R.drawable.avatar5, "Pranjul", "7252995449"));

        adapter = new RecyclerContactAdapter(MainActivity.this, arrContacts);
        recyclerContact.setAdapter(adapter);
    }
}