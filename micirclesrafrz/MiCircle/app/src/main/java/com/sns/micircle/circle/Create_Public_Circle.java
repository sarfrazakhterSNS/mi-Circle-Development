package com.sns.micircle.circle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.sns.micircle.R;

/**
 * Created by Vikas on 10/17/2016.
 */
public class Create_Public_Circle extends Activity {

    View viewright,viewleft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_circle);

        view();

        setClickOnviewleft();

        setClickonviewright();

    }



    private void setClickOnviewleft() {

        viewleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();

            }
        });
    }
    private void setClickonviewright() {

        viewright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Create_Public_Circle.this,Final_circle_Creation.class));

            }
        });
    }

    private void view() {

        viewright =(View)findViewById(R.id.viewright);
        viewleft =(View)findViewById(R.id.viewleft);
    }
}
