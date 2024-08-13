package com.example.osjcttwo;

import android.os.Bundle;
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
        // Add more items...

        adapter1 = new MyCustomAdapter(site_modelArrayList1, getApplicationContext());
        listView1.setAdapter(adapter1);
    }
}