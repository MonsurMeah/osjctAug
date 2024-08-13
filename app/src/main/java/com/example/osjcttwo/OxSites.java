package com.example.osjcttwo;

import android.os.Bundle;
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

        site_modelArrayList3 = new ArrayList<>();
        site_modelArrayList3.add(new site_model("Windsor St", R.drawable.windsorst));
        site_modelArrayList3.add(new site_model("Jubilee Lodge", R.drawable.jubileelodge));
        // Add more items...

        adapter3 = new MyCustomAdapter(site_modelArrayList3, getApplicationContext());
        listView3.setAdapter(adapter3);
    }
}