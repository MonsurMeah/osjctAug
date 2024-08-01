package com.example.osjcttwo;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<site_model> {

    private ArrayList<site_model> sitesArrayList;



    Context context;

    public MyCustomAdapter(ArrayList<site_model> sitesArrayList, Context context) {
        super(context, R.layout.item_list_layout, sitesArrayList);
        this.sitesArrayList = sitesArrayList;
        this.context = context;
    }


    private static class MyViewHolder{
        //taken from site_model, and not item_list_layout.xml
        TextView siteName;
        ImageView siteImage;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //is SiteModel an instance of site_model, siteModel was available from auto list
        //1- Get the sitemodel object for the current position
        site_model siteModel = getItem(position);

        //note the myViewHolder is case sen first letter, object is instance of MyViewHolder
        //2 - Inflate Layout
        MyViewHolder myViewHolder;
        final View result;

        if (convertView == null) {
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );

            //siteName taken from site_model.java and, sitetextview taken from item_list_layout.xml
            myViewHolder.siteName = (TextView) convertView.findViewById(R.id.sitetextview);
            myViewHolder.siteImage = (ImageView) convertView.findViewById(R.id.siteimageview);

            result = convertView;

            convertView.setTag(myViewHolder);
            }else{
            //Note the difference between in capitals between myView and MyView
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;

        }

        //note we are using the object of site_model
        myViewHolder.siteName.setText(siteModel.getSiteName());
        myViewHolder.siteImage.setImageResource(siteModel.getSiteImage());

        return convertView;

    }

}



