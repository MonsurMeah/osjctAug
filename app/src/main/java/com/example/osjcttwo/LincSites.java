package com.example.osjcttwo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;  // <-- Import the View class
import android.widget.AdapterView;  // <-- Import AdapterView for OnItemClickListener
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LincSites extends AppCompatActivity {
    ListView listView1;
    ArrayList<site_model> site_modelArrayList1;
    private static MyCustomAdapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linc_list);

        listView1 = findViewById(R.id.listview1);

        site_modelArrayList1 = new ArrayList<>();
        site_modelArrayList1.add(new site_model("AppleTrees", R.drawable.appletrees));
        site_modelArrayList1.add(new site_model("Beckside", R.drawable.beckside));
        site_modelArrayList1.add(new site_model("Boulthampk", R.drawable.boulthampk));
        site_modelArrayList1.add(new site_model("Digby Court", R.drawable.digbycourt));
        // Add more sites as needed...

        adapter1 = new MyCustomAdapter(site_modelArrayList1, getApplicationContext());
        listView1.setAdapter(adapter1);

        // Handle the item click in the ListView
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected site name
                String selectedSite = site_modelArrayList1.get(position).getSiteName();

                // Create an intent to pass the selected site back to save_item activity
                Intent intent = new Intent(LincSites.this, save_item.class);
                intent.putExtra("selectedSite", selectedSite);
                startActivity(intent);  // Start the save_item activity
            }
        });
    }
}