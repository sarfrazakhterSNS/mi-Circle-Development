package com.sns.micircle.location;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sns.micircle.R;

/**
 * Created by Vikas on 10/13/2016.
 */

public class Default_Frag_Location extends Fragment {

    ImageView imageVi_List;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_location_grid, container, false);

        view(v);

        setClickOnimageVi_List();

        return v;

    }

    private void setClickOnimageVi_List() {

        imageVi_List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.Fragment_Location, new Location_list_Activity());
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                transaction.commit();

            }
        });
    }

    private void view(View v) {

        imageVi_List = (ImageView)v.findViewById(R.id.imageVi_List);
    }
}

