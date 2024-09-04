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
        site_modelArrayList4.add(new site_model("Ashwood", R.drawable.ashwood));
        site_modelArrayList4.add(new site_model("Athelstan", R.drawable.athelstan));
        site_modelArrayList4.add(new site_model("Avonbourne", R.drawable.avonbourne));
        site_modelArrayList4.add(new site_model("Bemerton Lodge", R.drawable.bemertonlodge));
        site_modelArrayList4.add(new site_model("Brookside", R.drawable.brookside));
        site_modelArrayList4.add(new site_model("Buckland Court", R.drawable.bucklandcourt));
        site_modelArrayList4.add(new site_model("The Cedars", R.drawable.cedars));
        site_modelArrayList4.add(new site_model("Coombe End", R.drawable.coombeec));
        site_modelArrayList4.add(new site_model("Florence Court", R.drawable.florencecourt));
        site_modelArrayList4.add(new site_model("Goodson Lodge", R.drawable.goodsonlodge));
        site_modelArrayList4.add(new site_model("Hayward", R.drawable.hayward));
        site_modelArrayList4.add(new site_model("Hungerford", R.drawable.hungerfordhouse));
        site_modelArrayList4.add(new site_model("Marden Court", R.drawable.mardencourt));
        site_modelArrayList4.add(new site_model("Ridgeway", R.drawable.ridgewaywilts));
        site_modelArrayList4.add(new site_model("Seymour House", R.drawable.seymour));
        site_modelArrayList4.add(new site_model("St Wilfreds", R.drawable.stwilfrids));
        site_modelArrayList4.add(new site_model("Watersmead", R.drawable.watersmead));
        site_modelArrayList4.add(new site_model("Willowcroft", R.drawable.willowcroft));





        // Add more items as needed...

        adapter4 = new MyCustomAdapter(site_modelArrayList4, getApplicationContext());
        listView4.setAdapter(adapter4);
    }
}