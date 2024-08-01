package com.example.osjcttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListPopulate extends AppCompatActivity {
    ListView listView;

    ArrayList<site_model> site_modelArrayList;
    private static MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. AdapterView: a ListView
        listView = findViewById(R.id.listview);

        //2 - Data Source: ArrayList<site_model>
        //GLos
        site_modelArrayList = new ArrayList<>();





        site_model siteModel1 = new site_model("AppleTrees",R.drawable.appletrees);
        site_model siteModel2 = new site_model("Beckside",R.drawable.beckside);
        site_model siteModel3 = new site_model("Boultham Park",R.drawable.boulthampk);
        site_model siteModel4 = new site_model("Chestnut Court",R.drawable.chestnutcourt);
        site_model siteModel5 = new site_model("Digby Court",R.drawable.digbycourt);
        site_model siteModel6 = new site_model("Edwardstow",R.drawable.edwardstow);
        site_model siteModel7 = new site_model("Grace CC",R.drawable.gracecc);
        site_model siteModel8 = new site_model("Grevil House",R.drawable.grevilhouse);
        site_model siteModel9 = new site_model("Henlow Court",R.drawable.henlowcourt);
        site_model siteModel10 = new site_model("Jubilee Lodge",R.drawable.jubileelodge);
        site_model siteModel11 = new site_model("Milbrook Lodge",R.drawable.millbrooklodge);
        site_model siteModel12 = new site_model("Monkscroft",R.drawable.monkscroft);
        site_model siteModel13 = new site_model("Paternoster House",R.drawable.paternosterhouse);
        site_model siteModel14 = new site_model("Rodley House",R.drawable.rodleyhouse);
        site_model siteModel15 = new site_model("The Coombs",R.drawable.thecoombs);
        site_model siteModel16 = new site_model("The Lakes CC",R.drawable.thelakescc);
        site_model siteModel17 = new site_model("Windsor St",R.drawable.windsorst);
        site_model siteModel18 = new site_model("Test",R.drawable.windsorst);




        site_modelArrayList.add(siteModel1);
        site_modelArrayList.add(siteModel2);
        site_modelArrayList.add(siteModel3);
        site_modelArrayList.add(siteModel4);
        site_modelArrayList.add(siteModel5);
        site_modelArrayList.add(siteModel6);
        site_modelArrayList.add(siteModel7);
        site_modelArrayList.add(siteModel8);
        site_modelArrayList.add(siteModel9);
        site_modelArrayList.add(siteModel10);
        site_modelArrayList.add(siteModel11);
        site_modelArrayList.add(siteModel12);
        site_modelArrayList.add(siteModel13);
        site_modelArrayList.add(siteModel14);
        site_modelArrayList.add(siteModel15);
        site_modelArrayList.add(siteModel16);
        site_modelArrayList.add(siteModel17);
        site_modelArrayList.add(siteModel18);

        //Adapter
        adapter = new MyCustomAdapter(site_modelArrayList,getApplicationContext());



        listView.setAdapter(adapter);

    }
}