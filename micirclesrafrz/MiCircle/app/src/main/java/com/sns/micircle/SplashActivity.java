package com.sns.micircle;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class SplashActivity extends Activity {



    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 4000;

    ImageView imageView_rotating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_splash);


        showSplash();


        imageView_rotating = (ImageView)findViewById(R.id.imageView_Splash);
        ObjectAnimator animation = ObjectAnimator.ofFloat(imageView_rotating, "rotationY",1.0f, 360f);
        animation.setDuration(1800);
        animation.setRepeatCount(ObjectAnimator.INFINITE);
        animation.setInterpolator(new LinearInterpolator());
        animation.start();

    }

    private void showSplash() {
        // TODO Auto-generated method stub
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    imageView_rotating.clearAnimation();
                    finish();



            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
