package com.sns.micircle.circle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.sns.micircle.R;


/**
 * Created by Vikas on 10/17/2016.
 */
public class Create_Private_Circle extends Activity {

    View viewright,viewleft_private_private;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_circle);

        view();

        setClickOnviewright();

        setClickonviewleft_private_private();

    }

    private void setClickonviewleft_private_private() {

        viewleft_private_private.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();

            }
        });
    }

    private void setClickOnviewright() {

        viewright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(Create_Private_Circle.this,Final_circle_Creation.class));

            }
        });
    }

    private void view() {

        viewright =(View)findViewById(R.id.viewright);
        viewleft_private_private=(View)findViewById(R.id.viewleft_private_private);
    }
}
