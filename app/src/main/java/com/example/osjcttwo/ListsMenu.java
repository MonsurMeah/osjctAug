package com.example.osjcttwo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ListsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_main);

        // Find the buttons in the layout
        Button btnOpenList1 = findViewById(R.id.btnOpenList1);
        Button btnOpenList2 = findViewById(R.id.btnOpenList2);
        Button btnOpenList3 = findViewById(R.id.btnOpenList3);
        Button btnOpenList4 = findViewById(R.id.btnOpenList4);  // Initialize the button for List 4
        Button mapbutton = findViewById(R.id.mapbutton);

        // Set click listeners for each button
        btnOpenList1.setOnClickListener(v -> {
            Intent intent = new Intent(ListsMenu.this, LincSites.class);
            startActivity(intent);
        });

        btnOpenList2.setOnClickListener(v -> {
            Intent intent = new Intent(ListsMenu.this, GlosSites.class);
            startActivity(intent);
        });

        btnOpenList3.setOnClickListener(v -> {
            Intent intent = new Intent(ListsMenu.this, OxSites.class);
            startActivity(intent);
        });

        btnOpenList4.setOnClickListener(v -> {  // OnClickListener for List 4
            Intent intent = new Intent(ListsMenu.this, WiltSites.class);
            startActivity(intent);
        });

        mapbutton.setOnClickListener(v -> {
            Intent intent = new Intent(ListsMenu.this, GMapActivity.class);
            startActivity(intent);
        });
    }
}