package com.sns.micircle.setting;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;



/**
 * Created by Rashid on 10/12/2016.
 */

public class MiSetting extends AppCompatActivity {

    ImageView left_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      // setContentView(R.layout.activity_setting_main);

      //  view();

      //  setClickOnleft_arrow();
    }

    private void setClickOnleft_arrow() {

        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();

            }
        });
    }

    private void view() {

      //  left_arrow = (ImageView)findViewById(R.id.iv_left_arrow);
    }
}
