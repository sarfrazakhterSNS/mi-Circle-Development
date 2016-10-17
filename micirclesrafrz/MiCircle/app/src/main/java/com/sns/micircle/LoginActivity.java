package com.sns.micircle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends Activity {

	Button buttonLogin, buttonJoin;

	TextView  tv_forget_pass,tv_not_yet, tv_hed_log_sig;

	EditText editTextUserName, editTextPassword, et_mobile_number, et_emailid;

	ImageButton btnFB, btnGoogle, btnLinkedIn;

	Dialog dialogForgotPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		setContentView(R.layout.activity_login);

		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		views();

		setClickOnButtonJoin();

		setClickListenerOnButtonLogin();

		setClickListenerbtnFB();

		setClickListener_GooglePLus();

		setClickListener_LinkedIn();

		setClickOntv_forget_pass();



	}


	private void setClickListener_LinkedIn() {
		// TODO Auto-generated method stub
		btnLinkedIn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(LoginActivity.this, "you Clicked on linkedIn", Toast.LENGTH_SHORT).show();

			}
		});
	}

	private void setClickListenerbtnFB() {
		// TODO Auto-generated method stub
		btnFB.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(LoginActivity.this, "Don't mess with Mark!! ;)", Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void setClickListener_GooglePLus() {
		// TODO Auto-generated method stub
		btnGoogle.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Toast.makeText(LoginActivity.this, "you Clicked on gPlus", Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void setClickListenerOnButtonLogin() {

		buttonLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			    String userName=	editTextUserName.getText().toString();
                String password=   editTextPassword.getText().toString();

                if(editTextUserName.getText().length()==0){
                    editTextUserName.setError("Please Enter UseName!");
                }if( editTextPassword.getText().length()==0){
                    editTextPassword.setError("Please Enter Password!");
                }if(userName.length()>0 && password.length()>0) {

                    Toast.makeText(LoginActivity.this, "you Clicked on Login", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, HomeMainActivity.class));
                }
			}

		});

	}


	private void setClickOnButtonJoin() {
		// TODO Auto-generated method stub

		buttonJoin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Toast.makeText(LoginActivity.this, "welcome Boss :)", Toast.LENGTH_SHORT).show();
							}
		});

	}

	private void views() {
		// TODO Auto-generated method stub

		// Buttons
		buttonLogin = (Button) findViewById(R.id.buttonlogin);
		buttonJoin = (Button) findViewById(R.id.buttonJoin);
		btnFB = (ImageButton) findViewById(R.id.register_btnFB);
		btnGoogle = (ImageButton) findViewById(R.id.register_btnGoogle);
		btnLinkedIn = (ImageButton) findViewById(R.id.register_btnLinkedIn);

		// EditTexts
		editTextUserName = (EditText) findViewById(R.id.editTextUserName);
		editTextPassword = (EditText) findViewById(R.id.editTextPassword);

		// TextView
		tv_forget_pass = (TextView) findViewById(R.id.tv_forget_pass);
		tv_not_yet = (TextView) findViewById(R.id.tv_not_yet);
		tv_hed_log_sig = (TextView) findViewById(R.id.tv_hed_log_sig);

	}

	//method to forget password...
	private void setClickOntv_forget_pass() {
		// TODO Auto-generated method stub

		tv_forget_pass.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				dialogForgotPassword = new Dialog(LoginActivity.this);
				dialogForgotPassword.requestWindowFeature(Window.FEATURE_NO_TITLE);
				dialogForgotPassword.setContentView(R.layout.forgotpass_email);

				TextView tv_context = (TextView) dialogForgotPassword.findViewById(R.id.tv_context);

				et_mobile_number = (EditText) dialogForgotPassword.findViewById(R.id.etDialog_mobile_number);

				et_emailid = (EditText) dialogForgotPassword.findViewById(R.id.etDialog_emailid);

				Button buttonSubmit = (Button) dialogForgotPassword.findViewById(R.id.buttonSubmit);

				buttonSubmit.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub


							Toast.makeText(LoginActivity.this, "work in progress!!!", Toast.LENGTH_LONG).show();

					}

				});

				ImageButton button_cancel = (ImageButton) dialogForgotPassword.findViewById(R.id.imageButtonCancel);

				button_cancel.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub

						dialogForgotPassword.dismiss();

					}

				});

				dialogForgotPassword.show();
			}

		});

	}



	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(this).setMessage("Are You Sure! you want to exit?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {

				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 

				startActivity(intent);
				finish();

			}
		}).setNegativeButton("No", null).show();
	}



}