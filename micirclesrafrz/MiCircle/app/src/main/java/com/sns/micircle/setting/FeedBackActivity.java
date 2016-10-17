package com.sns.micircle.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.sns.micircle.R;
import com.sns.micircle.adapter.MyAdapter;

/**
 * Created by Rashid on 10/13/2016.
 */

public class FeedBackActivity extends Activity {
    Spinner spinner_feedType;
    Button btn_submitFeeds;
    EditText et_feedMail;
    TextView tv_headerText;
    ImageButton imageButton_backArrow;

    // Declaring the String Array with the Text Data for the Spinners
    String[] Languages = { "mi-Circle","mi-happening", "Circle", "Location",
            "Panic", "Friends","Notifications" };
    // Declaring the Integer Array with resourse Id's of Images for the Spinners
    Integer[] images = { 0, R.drawable.headerhappening, R.drawable.circledrawertemp,
            R.drawable.headerlocation, R.drawable.panicheaderwhite, R.drawable.headerfriend, R.drawable.notificationheaderwhite };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_feedback);

        view();

        spinner_feedType.setAdapter(new MyAdapter(this, Languages, images));

        setClickOnbtn_submitFeeds();

        setClickListeneronBackArrow();


    }

    private void setClickOnbtn_submitFeeds() {
        btn_submitFeeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String feedtext= et_feedMail.getText().toString();


                Integer indexValue = spinner_feedType.getSelectedItemPosition();
                String sub= Languages[indexValue];
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "feedback@mi-circle.com" });
                Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback: " +sub);
                Email.putExtra(Intent.EXTRA_TEXT,feedtext + "");
                startActivity(Intent.createChooser(Email, "Send Feedback:"));
            }
        });
    }

    private void setClickListeneronBackArrow() {
        imageButton_backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void view() {
        imageButton_backArrow= (ImageButton)findViewById(R.id.imageButton_back);
        tv_headerText=(TextView)findViewById(R.id.tv_headerfeedback);
        spinner_feedType=(Spinner)findViewById(R.id.spinner_feed);
        btn_submitFeeds=(Button)findViewById(R.id.btn_submitFeeds);
        et_feedMail=(EditText)findViewById(R.id.et_feedMail);
    }
}
