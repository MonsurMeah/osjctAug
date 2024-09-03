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
        site_modelArrayList2.add(new site_model("Chestnut Court", R.drawable.chestnutcourt));
        site_modelArrayList2.add(new site_model("Edwardstow CC", R.drawable.edwardstow));
        site_modelArrayList2.add(new site_model("Grevil House", R.drawable.grevilhouse));
        site_modelArrayList2.add(new site_model("Henlow Court", R.drawable.henlowcourt));
        site_modelArrayList2.add(new site_model("Jubilee Lodge", R.drawable.jubileelodge));
        site_modelArrayList2.add(new site_model("Monkscroft", R.drawable.monkscroft));
        site_modelArrayList2.add(new site_model("Paternoster House", R.drawable.paternosterhouse));
        site_modelArrayList2.add(new site_model("Rodley House", R.drawable.rodleyhouse));
        site_modelArrayList2.add(new site_model("The Coombs", R.drawable.thecoombs));
        site_modelArrayList2.add(new site_model("The Lakes", R.drawable.thelakescc));
        site_modelArrayList2.add(new site_model("Windsor Street", R.drawable.windsorst));
        // Add more items...

        adapter2 = new MyCustomAdapter(site_modelArrayList2, getApplicationContext());
        listView2.setAdapter(adapter2);
    }
}