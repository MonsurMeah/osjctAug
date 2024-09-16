package com.example.osjcttwo;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class Features_Menu extends AppCompatActivity {
    Button btn_scan, btn_reporting, btn_problem, button4;  // Add btn_reporting

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.features_menu);

        // Initialize the scan button
        btn_scan = findViewById(R.id.btn_scan);

        // Initialize the reporting button
        btn_reporting = findViewById(R.id.btn_reporting);
        btn_problem = findViewById(R.id.btn_problem);
        button4 = findViewById(R.id.button4);

        // Set click listener for the scan button
        btn_scan.setOnClickListener(v -> scanCode());

        // Set click listener for the reporting button
        btn_reporting.setOnClickListener(v -> openReporting());

        btn_problem.setOnClickListener(v -> openProblem());

        button4.setOnClickListener(v -> openAllDeviceSite());
    }

    // Method to initiate the scan
    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to turn flash");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
    }

    // Launcher for barcode scanning
    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), result -> {
        if (result.getContents() != null) {
            String assetTag = result.getContents(); // Capture the scanned code as assetTag
            showResultDialog(assetTag); // Show the result in a dialog
        }
    });

    // Method to show the result in a dialog
    private void showResultDialog(String assetTag) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Features_Menu.this);
        builder.setTitle("Result");
        builder.setMessage(assetTag);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();

                // Start the save_item activity and pass the assetTag
                Intent intent = new Intent(getApplicationContext(), save_item.class);
                intent.putExtra("assetTag", assetTag); // Use a distinct key "assetTag"
                startActivity(intent);
            }
        }).show();
    }

    // Method to open the SearchDeviceActivity
    private void openReporting() {
        Intent intent = new Intent(getApplicationContext(), SearchDeviceActivity.class);
        startActivity(intent);
    }

    private void openProblem() {
        Intent intent = new Intent(getApplicationContext(), CameraUploadActivity.class);
        startActivity(intent);
    }

    private void openAllDeviceSite() {
        Intent intent = new Intent(getApplicationContext(), AllDevicesAssignedtoSite.class);
        startActivity(intent);
    }

}