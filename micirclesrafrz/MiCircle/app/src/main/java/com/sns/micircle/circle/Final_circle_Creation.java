package com.sns.micircle.circle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sns.micircle.R;

/**
 * Created by Vikas on 10/17/2016.
 */
public class Final_circle_Creation extends Activity{

    View moveto_landing,viewleft;
    Button btn_finish,btn_cancel_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_final);

        view();

        setClickOnviewleft();

        setClickOnbtn_cancel_c();

        setClickOnbtn_finish();

        setClickOnmoveto_landing();
    }


    private void setClickOnviewleft() {

        viewleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();

            }
        });
    }

    private void setClickOnbtn_cancel_c() {

        btn_cancel_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();

            }
        });

    }

    private void setClickOnbtn_finish() {

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Final_circle_Creation.this,Circle_Landing.class));

            }
        });
    }

    private void setClickOnmoveto_landing() {

        moveto_landing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Final_circle_Creation.this,Circle_Landing.class));

            }
        });
    }

    private void view() {

        viewleft =(View)findViewById(R.id.viewleft);
        moveto_landing=(View)findViewById(R.id.moveto_landing);

        btn_cancel_c =(Button)findViewById(R.id.btn_cancel_c);
        btn_finish =(Button)findViewById(R.id.btn_finish);
    }
}
