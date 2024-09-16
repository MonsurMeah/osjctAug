package com.example.osjcttwo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class OxSites extends AppCompatActivity {
    ListView listView3;
    ArrayList<site_model> site_modelArrayList3;
    private static MyCustomAdapter adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ox_list);

        listView3 = findViewById(R.id.listview3);

        // Initialize the site model array list with site names and corresponding images
        site_modelArrayList3 = new ArrayList<>();
        site_modelArrayList3.add(new site_model("Centurion House", R.drawable.centurionhouse));
        site_modelArrayList3.add(new site_model("Chilterns Court CC", R.drawable.chilternscourtcc));
        site_modelArrayList3.add(new site_model("Henry Cornish", R.drawable.henrycornish));
        site_modelArrayList3.add(new site_model("Isis Court", R.drawable.isiscourt));
        site_modelArrayList3.add(new site_model("Isis House", R.drawable.isishouse));
        site_modelArrayList3.add(new site_model("Lake House", R.drawable.lakehouse));
        site_modelArrayList3.add(new site_model("Langford", R.drawable.langford));
        site_modelArrayList3.add(new site_model("Larkrise", R.drawable.larkrise));
        site_modelArrayList3.add(new site_model("Longlands", R.drawable.longlands));
        site_modelArrayList3.add(new site_model("Madley Park", R.drawable.madleypark));
        site_modelArrayList3.add(new site_model("Marston Court", R.drawable.marstoncourt));
        site_modelArrayList3.add(new site_model("Mayott", R.drawable.mayott));
        site_modelArrayList3.add(new site_model("Meadow Croft", R.drawable.meadowcroft));
        site_modelArrayList3.add(new site_model("Old Station House", R.drawable.oldstationhouse));
        site_modelArrayList3.add(new site_model("Shotover", R.drawable.shotover));
        site_modelArrayList3.add(new site_model("Spencer Court", R.drawable.spencercourt));
        site_modelArrayList3.add(new site_model("Stirlings", R.drawable.stirlings));
        site_modelArrayList3.add(new site_model("The meadows", R.drawable.themeadows));
        site_modelArrayList3.add(new site_model("Townsend House", R.drawable.townsendhouse));
        site_modelArrayList3.add(new site_model("Westgate House", R.drawable.westgatehouse));
        // Add more items...

        // Initialize the custom adapter
        adapter3 = new MyCustomAdapter(site_modelArrayList3, getApplicationContext());
        listView3.setAdapter(adapter3);

        // Set up the click listener for list items
        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected site name
                String selectedSite = site_modelArrayList3.get(position).getSiteName();

                // Create an intent to pass the selected site back to save_item activity
                Intent intent = new Intent(OxSites.this, save_item.class);
                intent.putExtra("selectedSite", selectedSite);
                startActivity(intent);  // Start the save_item activity
            }
        });
    }
}
