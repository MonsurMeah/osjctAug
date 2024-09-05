package com.example.osjcttwo;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class CameraUploadActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST_CODE = 100;
    private static final int PERMISSION_REQUEST_CODE = 101;
    private Uri imageUri;  // URI to hold the captured image
    private TextView statusText;
    private EditText editTextDescription;  // To capture image description

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_upload);

        // Initialize UI components
        statusText = findViewById(R.id.statusText);
        editTextDescription = findViewById(R.id.editTextDescription); // Capture description input
        Button buttonCapture = findViewById(R.id.buttonCapture);

        // Check and request the necessary permissions when the button is clicked
        buttonCapture.setOnClickListener(v -> {
            if (checkPermissions()) {
                openCamera(); // Open the camera if permissions are granted
            } else {
                requestPermissions(); // Request necessary permissions if not already granted
            }
        });
    }

    // Method to check necessary permissions (Camera and Storage)
    private boolean checkPermissions() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_IMAGES) == PackageManager.PERMISSION_GRANTED;
    }

    // Request permissions for camera and external storage
    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.READ_MEDIA_IMAGES}, PERMISSION_REQUEST_CODE);
    }

    // Handle the permissions result
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera(); // Open camera if permission is granted
            } else {
                Toast.makeText(this, "Permissions Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Method to open the camera and store the image in MediaStore
    private void openCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From Camera");

        // Insert image into MediaStore and get the URI
        imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        if (imageUri == null) {
            statusText.setText("Error: Unable to create URI for the image.");
            Toast.makeText(this, "Error: Unable to create URI for the image.", Toast.LENGTH_SHORT).show();
            return;  // Stop further execution if URI is null
        }

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
    }

    // Handle the result from the camera
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            // Image captured successfully
            if (imageUri != null) {
                statusText.setText("Image captured, URI: " + imageUri.toString());
                uploadImageToFirebase(imageUri);  // Proceed to upload the image
            } else {
                statusText.setText("Error: Image URI is null after capture.");
                Toast.makeText(this, "Error: Image URI is null after capture.", Toast.LENGTH_SHORT).show();
            }
        } else {
            statusText.setText("Image capture failed or canceled.");
        }
    }

    // Upload the captured image and description to Firebase Storage and Realtime Database
    private void uploadImageToFirebase(Uri imageUri) {
        if (imageUri != null) {
            // Get the image description from the EditText
            String description = editTextDescription.getText().toString();

            // Create a reference in Firebase Storage
            StorageReference storageRef = FirebaseStorage.getInstance().getReference();
            StorageReference imagesRef = storageRef.child("images/" + System.currentTimeMillis() + ".jpg");

            // Log the storage path
            statusText.setText("Uploading to: " + imagesRef.getPath());

            try {
                InputStream inputStream = getContentResolver().openInputStream(imageUri);

                if (inputStream != null) {
                    UploadTask uploadTask = imagesRef.putStream(inputStream);
                    uploadTask.addOnSuccessListener(taskSnapshot -> {
                        // Retrieve the download URL of the uploaded image
                        imagesRef.getDownloadUrl().addOnSuccessListener(uri -> {
                            String downloadUrl = uri.toString();

                            // Store the image description and URL in Realtime Database
                            DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("images");
                            String imageId = databaseRef.push().getKey();

                            Map<String, String> imageDetails = new HashMap<>();
                            imageDetails.put("description", description);
                            imageDetails.put("imageUrl", downloadUrl);

                            if (imageId != null) {
                                databaseRef.child(imageId).setValue(imageDetails).addOnSuccessListener(aVoid -> {
                                    statusText.setText("Image and description uploaded successfully");
                                    Toast.makeText(this, "Image and description uploaded", Toast.LENGTH_SHORT).show();
                                }).addOnFailureListener(e -> {
                                    statusText.setText("Failed to upload image and description: " + e.getMessage());
                                    Toast.makeText(this, "Failed to upload image and description", Toast.LENGTH_SHORT).show();
                                });
                            }
                        });
                    }).addOnFailureListener(e -> {
                        statusText.setText("Image Upload Failed: " + e.getMessage());
                        Toast.makeText(this, "Image Upload Failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
                } else {
                    statusText.setText("Error: InputStream is null.");
                    Toast.makeText(this, "Error: InputStream is null.", Toast.LENGTH_SHORT).show();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                statusText.setText("Failed to open image file");
                Toast.makeText(this, "Failed to open image file", Toast.LENGTH_SHORT).show();
            }
        } else {
            statusText.setText("No Image Captured");
            Toast.makeText(this, "No Image Captured", Toast.LENGTH_SHORT).show();
        }
    }
}