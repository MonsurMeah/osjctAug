package com.example.osjcttwo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class save_item extends AppCompatActivity {

    private Button button, button2, button3, button4;
    private TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_item);

        textView4 = findViewById(R.id.textView4);
        button = findViewById(R.id.button);


        // Retrieve the asset tag from the intent
        Intent intent = getIntent();
        String assetTag = intent.getStringExtra("name");

        // Display the asset tag in the TextView
        if (assetTag != null) {
            textView4.setText(assetTag);
        }

        // Set up button click listeners

        // Button 1: Navigate to ListPopulateGlos activity
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ListsMenu.class);
                startActivity(i);
            }
        });

        
    }
}