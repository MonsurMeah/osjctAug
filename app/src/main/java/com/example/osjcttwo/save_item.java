package com.example.osjcttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class save_item extends AppCompatActivity {

    private Button buttonlinc;
    private Button buttonglos;

    private TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_item);

        textView4 = findViewById(R.id.textView4);
        buttonglos = findViewById(R.id.buttonglos);
        buttonlinc =findViewById(R.id.buttonlinc);




        // Retrieve the asset tag from the intent
        Intent intent = getIntent();
        String assetTag = intent.getStringExtra("name");

        // Display the asset tag in the TextView
        if (assetTag != null) {
            textView4.setText(assetTag);
        }

        //the main_activity waits for the button to be pressed
        buttonglos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(
                        getApplicationContext(),
                        //Default MainActivity3.class
                        ListPopulateGlos.class

                );

                startActivity(i);


            }
        });

        buttonlinc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent j = new Intent(
                        getApplicationContext(),
                        //Default MainActivity3.class
                        ListPopulateGlos.class

                );

                startActivity(j);


            }
        });

    }
}