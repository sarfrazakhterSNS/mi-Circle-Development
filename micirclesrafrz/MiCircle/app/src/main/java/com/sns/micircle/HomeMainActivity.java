package com.sns.micircle;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sns.micircle.circle.CircleActivity;
import com.sns.micircle.friend.FriendActivity;
import com.sns.micircle.happenings.MiHappenings;
import com.sns.micircle.location.LocationActivity;
import com.sns.micircle.notification.MiNotification;
import com.sns.micircle.panic.MiPanic;
import com.sns.micircle.setting.MiSetting;

public class HomeMainActivity extends Activity {

	Animation anim_scale;

	ImageView imageView1;
	//TextView textView1, tv_happ, tv_circle, tv_panic, tv_friends, textVi_location, textVi_notification, textVi_Apps, textVi_Panicr, tv_signout, tv_seeting;

	FrameLayout viewpanic, viewcircle, friends, viewfavlocation,  notification, viewApps, viewmi_setting, viewPnew, viewhap;
	View viewsignout;
	ImageButton compose;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_main);

		views();

		//setClickListenerOnviewsignout();

		setClickOnviewhap();

		setClickOnviewpanic();

		setClickOnviewcircle();

		setClickOnfriends();

		setClickOnviewfavlocation();

		setClickOnnotification();

		setClickOnviewApps();

		setClickOnviewmi_setting();

		setClickOnviewPnew();

		//setClickOncompose();

	}

	private void setClickOncompose() {
		// TODO Auto-generated method stub

		compose.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Toast.makeText(HomeMainActivity.this, "sss!!!!!", Toast.LENGTH_SHORT).show();
				/*Intent i = new Intent(HomeMainActivity.this, PreChat.class);
				startActivity(i);
*/
			}
		});

	}


	private void setClickOnviewPnew() {
		// TODO Auto-generated method stub

		viewPnew.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.startAnimation(anim_scale);
				Toast.makeText(HomeMainActivity.this, " be careful buddy!", Toast.LENGTH_SHORT).show();
				startActivity(new Intent(HomeMainActivity.this, CameraPanic.class));

			}
		});

	}




	private void setClickOnviewmi_setting() {
		// TODO Auto-generated method stub

		viewmi_setting.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				v.startAnimation(anim_scale);
				startActivity(new Intent(HomeMainActivity.this,MiSetting.class));
			}
		});

	}

	private void setClickOnviewApps() {
		// TODO Auto-generated method stub

		viewApps.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.startAnimation(anim_scale);
				// custom dialog
				final Dialog dialog = new Dialog(HomeMainActivity.this);
				dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //before     
				dialog.setContentView(R.layout.viewapps_main);

				dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
				dialog.show();


			}
		});

	}

	private void setClickOnnotification() {
		// TODO Auto-generated method stub

		notification.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.startAnimation(anim_scale);
				Toast.makeText(HomeMainActivity.this, "mi-notigfications", Toast.LENGTH_SHORT).show();
				startActivity(new Intent(HomeMainActivity.this, MiNotification.class));

			}
		});

	}

	private void setClickOnviewfavlocation() {
		// TODO Auto-generated method stub

		viewfavlocation.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				v.startAnimation(anim_scale);
				startActivity(new Intent(HomeMainActivity.this,LocationActivity.class));
			}
		});

	}

	private void setClickOnfriends() {
		// TODO Auto-generated method stub

		friends.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.startAnimation(anim_scale);
				startActivity(new Intent(HomeMainActivity.this,FriendActivity.class));
			}
		});

	}

	private void setClickOnviewcircle() {
		// TODO Auto-generated method stub

		viewcircle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				v.startAnimation(anim_scale);
				startActivity(new Intent(HomeMainActivity.this, CircleActivity.class));
			}

		});

	}

	private void setClickOnviewpanic() {
		// TODO Auto-generated method stub

		viewpanic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.startAnimation(anim_scale);
				Toast.makeText(HomeMainActivity.this, "get some help......!!", Toast.LENGTH_SHORT).show();
				startActivity(new Intent(HomeMainActivity.this, MiPanic.class));

			}
		});

	}

	private void setClickOnviewhap() {
		// TODO Auto-generated method stub

		viewhap.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.startAnimation(anim_scale);
				Toast.makeText(HomeMainActivity.this, "whatever", Toast.LENGTH_SHORT).show();
				startActivity(new Intent(HomeMainActivity.this, MiHappenings.class));
			}

		});

	}

	private void setClickListenerOnviewsignout() {
		// TODO Auto-generated method stub

		viewsignout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {


				AlertDialog.Builder builder = new AlertDialog.Builder(HomeMainActivity.this);
				AlertDialog alertDialog = builder.create();

				alertDialog.setMessage("Do You Want to Logout??");
				alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int whichButton) {



						finish();
					}

				});

				alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
					}
				});
				alertDialog.show();

			}
		});

	}

	private void views() {
		// TODO Auto-generated method stub

		imageView1 = (ImageView) findViewById(R.id.imageView1);
		//viewsignout = (View) findViewById(R.id.viewsignout);
		viewhap = (FrameLayout) findViewById(R.id.Layout_Happening);
		viewpanic = (FrameLayout) findViewById(R.id.Layout_Panic);
		viewcircle = (FrameLayout) findViewById(R.id.Layout_Circle);
		friends = (FrameLayout) findViewById(R.id.Layout_Friend);
		viewfavlocation = (FrameLayout) findViewById(R.id.Layout_Location);
		notification = (FrameLayout) findViewById(R.id.Layout_Notification);
		viewApps = (FrameLayout) findViewById(R.id.Layout_Apps);
		viewmi_setting = (FrameLayout) findViewById(R.id.Layout_Settings);
		viewPnew = (FrameLayout) findViewById(R.id.Layout_m);
		//textView1 = (TextView) findViewById(R.id.textView1);
		//compose = (ImageButton) findViewById(R.id.composebutton_sugges_friendhome);

		// textView //

		//tv_happ = (TextView) findViewById(R.id.tv_happ);
		/*tv_circle = (TextView) findViewById(R.id.tv_circle);
		tv_panic = (TextView) findViewById(R.id.tv_panic);
		tv_friends = (TextView) findViewById(R.id.tv_friends);
		textVi_location = (TextView) findViewById(R.id.textVi_location);
		textVi_notification = (TextView) findViewById(R.id.textVi_notification);
		textVi_Apps = (TextView) findViewById(R.id.textVi_Apps);
		textVi_Panicr = (TextView) findViewById(R.id.textVi_Panicr);
		tv_signout = (TextView) findViewById(R.id.tv_signout);
		tv_seeting = (TextView) findViewById(R.id.tv_seeting);*/

		anim_scale = AnimationUtils.loadAnimation(HomeMainActivity.this, R.anim.anim_scale);

	}

	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(this).setMessage("Are You Sure You Want To Exit?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {

				Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
				intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
				finish();
				startActivity(intent1);


			}
		}).setNegativeButton("No", null).show();
	}



	}
