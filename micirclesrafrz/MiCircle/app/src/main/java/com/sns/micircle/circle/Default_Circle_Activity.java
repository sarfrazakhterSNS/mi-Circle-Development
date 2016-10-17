package com.sns.micircle.circle;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sns.micircle.R;

/**
 * Created by Vikas on 10/14/2016.
 */
public class Default_Circle_Activity extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_circle_default, container, false);



        return v;
    }
}