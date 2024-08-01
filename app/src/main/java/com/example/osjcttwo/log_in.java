package com.example.osjcttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class log_in extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //In this instance log_in is the main activity
        setContentView(R.layout.log_in);

        //the main_activity finds the view to use from the XML file
        btn = findViewById(R.id.btn);


        //the main_activity waits for the button to be pressed
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(
                        getApplicationContext(),
                        //Default MainActivity3.class
                        scan_button.class

                );

                startActivity(i);


            }
        });
    }
}