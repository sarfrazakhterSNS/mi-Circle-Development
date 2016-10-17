package com.sns.micircle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sns.micircle.R;
import com.sns.micircle.circle.CircleActivity;
import com.sns.micircle.circle.Circle_Landing;
import com.sns.micircle.friend.FriendActivity;
import com.sns.micircle.happenings.MiHappenings;
import com.sns.micircle.location.LocationActivity;
import com.sns.micircle.notification.MiNotification;
import com.sns.micircle.panic.MiPanic;

import java.util.ArrayList;

/**
 * Created by Rashid on 10/12/2016.
 */

public class DarawerListAdapter extends BaseAdapter {

    Context context;
    int[] imagesList;
    ArrayList<String> arr_headerList;

    public DarawerListAdapter(MiHappenings miHappenings, int[] image, ArrayList<String> arr_headers) {

        context= miHappenings;
        imagesList= image;
        arr_headerList= arr_headers;
    }

    public DarawerListAdapter(MiNotification miNotification, int[] image, ArrayList<String> arr_headers) {

        context= miNotification;
        imagesList=image;
        arr_headerList=arr_headers;
    }

    public DarawerListAdapter(MiPanic miPanic, int[] image, ArrayList<String> arr_headers) {
        context= miPanic;
        imagesList=image;
        arr_headerList=arr_headers;
    }

    public DarawerListAdapter(CircleActivity circleActivity, int[] image, ArrayList<String> arr_headers) {

        context= circleActivity;
        imagesList=image;
        arr_headerList=arr_headers;
    }

    public DarawerListAdapter(LocationActivity locationActivity, int[] image, ArrayList<String> arr_headers) {

        context= locationActivity;
        imagesList=image;
        arr_headerList=arr_headers;
    }

    public DarawerListAdapter(FriendActivity friendActivity, int[] image, ArrayList<String> arr_headers) {

        context= friendActivity;
        imagesList=image;
        arr_headerList=arr_headers;
    }

    public DarawerListAdapter(Circle_Landing circle_landing, int[] image, ArrayList<String> arr_headers) {

        context= circle_landing;
        imagesList=image;
        arr_headerList=arr_headers;
    }

    @Override
    public int getCount() {
        return arr_headerList.size();
    }

    @Override
    public Object getItem(int position) {
        return arr_headerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return arr_headerList.indexOf(position);
    }


    // TODO Auto-generated method stub
    public class ViewHolder {
        TextView headers;
        ImageView image;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.customdrawer_listitem, null);


            holder.headers = (TextView) convertView
                    .findViewById(R.id.tv_drawer_item);
            holder.image= (ImageView)convertView.findViewById(R.id.iv_drawer_item);

            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        holder.headers.setText(arr_headerList.get(position));
        holder.image.setImageResource(imagesList[position]);

        return convertView;

    }
}
