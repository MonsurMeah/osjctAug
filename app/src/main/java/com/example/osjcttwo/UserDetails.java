package com.example.osjcttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class UserDetails extends AppCompatActivity {

    ImageView imageview3,imageview2;
    EditText editTextTextEmailAddress, editTextTextPassword;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        imageview2 = findViewById(R.id.imageview2);
        imageview3 = findViewById(R.id.imageview3);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        button2 = findViewById(R.id.button2);

        //the main_activity waits for the button to be pressed
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(
                        getApplicationContext(),
                        //Default MainActivity3.class
                        Features_Menu.class

                );

                startActivity(i);


            }
        });
    }
}