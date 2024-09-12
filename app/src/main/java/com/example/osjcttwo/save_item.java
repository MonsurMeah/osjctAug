package com.example.osjcttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class save_item extends AppCompatActivity {

    private Button button, buttonSubmit,button5;
    private TextView textView4, textView5; // Declare TextView for site name
    private EditText editTextMake, editTextModel, editTextSerialNumber;
    private DatabaseReference databaseDevices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_item);

        // Initialize the TextViews and Buttons
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5); // Initialize new TextView for site name
        button = findViewById(R.id.button);
        button5 = findViewById(R.id.button5);

        // Retrieve the asset tag from the intent
        Intent intent = getIntent();
        String assetTag = intent.getStringExtra("assetTag");
        String selectedSite = intent.getStringExtra("selectedSite"); // Retrieve the selected site name

        // Display the asset tag in the TextView
        if (assetTag != null) {
            textView4.setText(assetTag);  // Preserve the asset tag
        }

        // Display the selected site in textView5
        if (selectedSite != null) {
            textView5.setText(selectedSite);  // Set the selected site in textView5
        }

        // Initialize Firebase Database reference
        databaseDevices = FirebaseDatabase.getInstance().getReference("devices");

        // Initialize UI elements
        editTextMake = findViewById(R.id.editTextMake);
        editTextModel = findViewById(R.id.editTextModel);
        editTextSerialNumber = findViewById(R.id.editTextSerialNumber);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Set up the button click listener for adding a device
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDevice();
            }
        });

        // Set up button click listeners for navigating to the ListsMenu
        button.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), ListsMenu.class);
            startActivity(i);
        });

        button5.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), Features_Menu.class);
            startActivity(i);
        });

    }

    private void addDevice() {
        // Get values from EditText fields
        String make = editTextMake.getText().toString().trim();
        String model = editTextModel.getText().toString().trim();
        String serialNumber = editTextSerialNumber.getText().toString().trim();
        String assetTag = textView4.getText().toString().trim();
        String siteName = textView5.getText().toString().trim();  // Get the selected site name

        if (make.isEmpty() || model.isEmpty() || assetTag.isEmpty() || serialNumber.isEmpty() || siteName.isEmpty()) {
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
            return;
        }

        // Generate a unique ID for the new device
        String id = databaseDevices.push().getKey();

        // Create a Device object
        Device device = new Device(id, make, model, serialNumber, assetTag, siteName);  // Add site name to Device object

        // Store device information in Firebase
        if (id != null) {
            databaseDevices.child(id).setValue(device);
            Toast.makeText(this, "Device added", Toast.LENGTH_SHORT).show();

            // Clear the input fields for the next entry
            editTextMake.setText("");
            editTextModel.setText("");
            editTextSerialNumber.setText("");
            textView4.setText("");
            textView5.setText("");  // Clear the selected site
        }
    }
}