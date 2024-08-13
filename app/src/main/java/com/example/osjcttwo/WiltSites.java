package com.example.osjcttwo;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class WiltSites extends AppCompatActivity {
    ListView listView4;
    ArrayList<site_model> site_modelArrayList4;
    private static MyCustomAdapter adapter4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wilt_list);  // Make sure you have activity_list4.xml

        listView4 = findViewById(R.id.listview4);  // Make sure you have listview4 in activity_list4.xml

        site_modelArrayList4 = new ArrayList<>();
        site_modelArrayList4.add(new site_model("Windsor St", R.drawable.windsorst));
        site_modelArrayList4.add(new site_model("Jubilee Lodge", R.drawable.jubileelodge));
        // Add more items as needed...

        adapter4 = new MyCustomAdapter(site_modelArrayList4, getApplicationContext());
        listView4.setAdapter(adapter4);
    }
}