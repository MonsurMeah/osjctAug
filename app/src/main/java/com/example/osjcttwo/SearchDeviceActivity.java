package com.example.osjcttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SearchDeviceActivity extends AppCompatActivity {

    private EditText editTextSearchMake, editTextSearchModel, editTextSearchSerial;
    private Button buttonSearchMake, buttonSearchModel, buttonSearchSerial, button5;
    private TextView textViewResult;

    private DatabaseReference databaseDevices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_device);

        // Initialize Firebase Database reference
        databaseDevices = FirebaseDatabase.getInstance().getReference("devices");

        // Initialize UI elements
        editTextSearchMake = findViewById(R.id.editTextSearchMake);
        editTextSearchModel = findViewById(R.id.editTextSearchModel);
        editTextSearchSerial = findViewById(R.id.editTextSearchSerial);
        buttonSearchMake = findViewById(R.id.buttonSearchMake);
        buttonSearchModel = findViewById(R.id.buttonSearchModel);
        buttonSearchSerial = findViewById(R.id.buttonSearchSerial);
        textViewResult = findViewById(R.id.textViewResult);
        button5 = findViewById(R.id.button5);

        // Set up button click listeners for each search option
        buttonSearchMake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchDeviceByField("make", editTextSearchMake.getText().toString().trim());
            }
        });

        buttonSearchModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchDeviceByField("model", editTextSearchModel.getText().toString().trim());
            }
        });

        buttonSearchSerial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchDeviceByField("serialNumber", editTextSearchSerial.getText().toString().trim());
            }
        });

        button5.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), Features_Menu.class);
            startActivity(i);
        });
    }

    private void searchDeviceByField(String field, String valueToSearch) {
        if (valueToSearch.isEmpty()) {
            Toast.makeText(this, "Please enter a value to search", Toast.LENGTH_SHORT).show();
            return;
        }

        // Query the Firebase database to search for devices by the specified field
        databaseDevices.orderByChild(field).equalTo(valueToSearch).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    StringBuilder result = new StringBuilder();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Device device = snapshot.getValue(Device.class);
                        if (device != null) {
                            result.append("Make: ").append(device.getMake()).append("\n")
                                    .append("Model: ").append(device.getModel()).append("\n")
                                    .append("Serial Number: ").append(device.getSerialNumber()).append("\n\n");
                        }
                    }
                    textViewResult.setText(result.toString());
                } else {
                    textViewResult.setText("No devices found with the specified " + field + ": " + valueToSearch);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(SearchDeviceActivity.this, "Error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}