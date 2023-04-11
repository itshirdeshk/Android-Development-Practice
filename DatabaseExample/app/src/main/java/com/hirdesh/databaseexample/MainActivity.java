package com.hirdesh.databaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDBHelper dbHelper = new MyDBHelper(this);
//        dbHelper.addContacts("Hirdesh", "7252995449");
//        dbHelper.addContacts("Madhav", "7252995449");
//        dbHelper.addContacts("Yash", "7252995449");
//        dbHelper.addContacts("Pranjal", "7252995449");
//        dbHelper.addContacts("Pranjul", "7252995449");

//        ContactModel model = new ContactModel();
//        model.id = 1;
//        model.name = "Raman";
//        model.phone_no = "1234567890";
//
//        dbHelper.updateContacts(model);

        dbHelper.deleteContacts(2);

        ArrayList<ContactModel> arrContacts = dbHelper.fetchContacts();

        for (int i = 0; i < arrContacts.size(); i++) {
            Log.d("CONTACT_INFO", "Name : " + arrContacts.get(i).name + " Phone Number : " + arrContacts.get(i).phone_no);
        }


    }
}