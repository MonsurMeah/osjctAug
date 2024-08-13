package com.example.osjcttwo;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GlosSites extends AppCompatActivity {
    ListView listView2;
    ArrayList<site_model> site_modelArrayList2;
    private static MyCustomAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glos_list);

        listView2 = findViewById(R.id.listview2);

        site_modelArrayList2 = new ArrayList<>();
        site_modelArrayList2.add(new site_model("Monkscroft", R.drawable.monkscroft));
        site_modelArrayList2.add(new site_model("Paternoster House", R.drawable.paternosterhouse));
        // Add more items...

        adapter2 = new MyCustomAdapter(site_modelArrayList2, getApplicationContext());
        listView2.setAdapter(adapter2);
    }
}