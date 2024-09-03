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
        site_modelArrayList1.add(new site_model("Boulthampk", R.drawable.boulthampk));
        site_modelArrayList1.add(new site_model("Digby Court", R.drawable.digbycourt));
        site_modelArrayList1.add(new site_model("Eresby Hall", R.drawable.eresbyhall));
        site_modelArrayList1.add(new site_model("Ermine House", R.drawable.erminehouse));
        site_modelArrayList1.add(new site_model("Beckside", R.drawable.beckside));
        site_modelArrayList1.add(new site_model("Foxby Court", R.drawable.foxbycourt));
        site_modelArrayList1.add(new site_model("Gregory House", R.drawable.gregoryhouse));
        site_modelArrayList1.add(new site_model("Hartsholme House", R.drawable.hartsholme));
        site_modelArrayList1.add(new site_model("Oxlip House", R.drawable.oxliphouse));
        site_modelArrayList1.add(new site_model("Patchett Lodge", R.drawable.patchettlodge));
        site_modelArrayList1.add(new site_model("Skirbeck Court", R.drawable.skirbeckcourt));
        site_modelArrayList1.add(new site_model("Southfield House", R.drawable.southfieldhouse));
        site_modelArrayList1.add(new site_model("The Poplars", R.drawable.whitefriars));
        site_modelArrayList1.add(new site_model("Whitefriars", R.drawable.whitefriars));
        // Add more items...

        adapter1 = new MyCustomAdapter(site_modelArrayList1, getApplicationContext());
        listView1.setAdapter(adapter1);
    }
}