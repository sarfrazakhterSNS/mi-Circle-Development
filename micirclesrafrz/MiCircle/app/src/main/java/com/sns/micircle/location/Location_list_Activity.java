package com.sns.micircle.location;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sns.micircle.R;

/**
 * Created by Vikas on 10/14/2016.
 */

public class Location_list_Activity extends Fragment {

    View viewback,view_List;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_location_list, container, false);

        view(v);

        setClickOnviewback();

        setClickOnview_List();

        return v;
    }

    private void setClickOnview_List() {

        view_List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getFragmentManager();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.Fragment_Location, new Default_Frag_Location());
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                transaction.commit();

            }
        });
    }

    private void setClickOnviewback() {

        viewback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getFragmentManager();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.Fragment_Location, new Default_Frag_Location());
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                transaction.commit();
                }
        });
    }

    private void view(View v) {

        viewback =(View)v.findViewById(R.id.viewback);
        view_List =(View)v.findViewById(R.id.view_List);
    }
}
