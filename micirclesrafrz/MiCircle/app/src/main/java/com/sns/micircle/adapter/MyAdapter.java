package com.sns.micircle.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.sns.micircle.R;
import com.sns.micircle.setting.FeedBackActivity;

/**
 * Created by Rashid on 10/13/2016.
 */
public class MyAdapter implements SpinnerAdapter {
    Context c;
    String[] lang;
    Integer[] icons;
    public MyAdapter(FeedBackActivity feedBackActivity, String[] languages, Integer[] images) {
        c= feedBackActivity;
        lang= languages;
        icons=images;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return lang.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String cur_string = lang[position];
        Integer cur_icon=icons[position];
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.rowlayout_spinner, parent, false);
        TextView label = (TextView) convertView.findViewById(R.id.tv_drawer_item);
        label.setText(cur_string);

        ImageView icon = (ImageView) convertView.findViewById(R.id.iv_drawer_item);
        icon.setImageResource(cur_icon);

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
