package com.sns.micircle.happenings;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import android.app.TabActivity;

import android.content.Intent;

import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import android.widget.PopupMenu;
import android.widget.TabHost;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import com.sns.micircle.HomeMainActivity;
import com.sns.micircle.R;
import com.sns.micircle.adapter.DarawerListAdapter;
import com.sns.micircle.panic.MiPanic;
import com.sns.micircle.setting.FAQSActivity;
import com.sns.micircle.setting.FeedBackActivity;
import com.sns.micircle.setting.MiSetting;
import com.sns.micircle.utility.DrawerArrowDrawable;

import static android.view.Gravity.*;

@SuppressWarnings("deprecation")
public class MiHappenings extends TabActivity {

	TabHost tHost;
	TabWidget tWidget;

	ArrayList<String> arr_Headers;

	Typeface tf;
	TextView tvHead_happeningFrag, tv_tabHeader, setting, feedback, faqs;

	DrawerArrowDrawable drawerArrowDrawable;
	DrawerLayout drawer;
	ImageView imV_drawer_Indicator;
	float offset;

	boolean flipped;
	ListView listView_options;
	Button location, messages;
	ImageButton search_hit;
	EditText etHeader;
	String friendId, number;


	ImageView imageViewpanic, imageViewnotification, imageViewsearchn, imageView8, imageView1, imageViewmore, button_left, imageView_threeBars, imageViewGrid_view, imageVi_List, imageView_home;

	int[] image = { R.drawable.profiledrawerwhite, R.drawable.headerfriend, R.drawable.headerlocation, R.drawable.circledrawertemp, R.drawable.panicheadern, R.drawable.headernotifi, R.drawable.headerseeting, };

	/***************************/
	
	/***************************/

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mi_happenings);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	
		views();

		tabHostSetup();

		//setSelectedTabColor();

		
		//setOnTabListener();
		
		setClickOnViewPanic();

		setClickOnviewnotification();

		setClickListenerOnIvHome();

		setClicklistenerOnIndicator();

		setClickListenerOnDrawer();

		setOnTouchListenerviewsearch();

		setClickListnerOnDrawerListItem();

		setClickListeneronThreeBars();

		arr_Headers = getDrawerHeaders();
		
		DarawerListAdapter mhlistadapter = new DarawerListAdapter(MiHappenings.this, image, arr_Headers);

		listView_options.setAdapter(mhlistadapter);
	}


	private void setClickListeneronThreeBars() {

		imageView_threeBars.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//Creating the instance of PopupMenu
				PopupMenu popup = new PopupMenu(MiHappenings.this, v);
				//Inflating the Popup using xml file
				setForceShowIcon(popup);
				popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

				//registering popup with OnMenuItemClickListener
				popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
					public boolean onMenuItemClick(MenuItem item) {

						if (item.getTitle().equals("Feedback")) {
							startActivity(new Intent(MiHappenings.this, FeedBackActivity.class));

							return true;
						} else if (item.getTitle().equals("FAQ's")) {
							startActivity(new Intent(MiHappenings.this, FAQSActivity.class));

							return true;

						} else if (item.getTitle().equals("Setting")) {
							startActivity(new Intent(MiHappenings.this,MiSetting.class));

							return true;
						}

						return false;
					}
				});

				popup.show();//showing popup menu

			}
		});
	}

	public static void setForceShowIcon(PopupMenu popupMenu) {
		try {
			Field[] fields = popupMenu.getClass().getDeclaredFields();
			for (Field field : fields) {
				if ("mPopup".equals(field.getName())) {
					field.setAccessible(true);
					Object menuPopupHelper = field.get(popupMenu);
					Class<?> classPopupHelper = Class.forName(menuPopupHelper
							.getClass().getName());
					Method setForceIcons = classPopupHelper.getMethod(
							"setForceShowIcon", boolean.class);
					setForceIcons.invoke(menuPopupHelper, true);
					break;
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}



	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		if (drawer.isDrawerVisible(LEFT)) {
			drawer.closeDrawer(LEFT);


		}else{
			super.onBackPressed();

		}

	}

	private void setClickListnerOnDrawerListItem() {
		// TODO Auto-generated method stub
		listView_options.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				if (position == 0) {

					drawer.closeDrawer(GravityCompat.START);



				}
				if (position == 1) {
					drawer.closeDrawer(GravityCompat.START);

				}
				if (position == 2) {
					drawer.closeDrawer(GravityCompat.START);



				}

				if (position == 3) {
					drawer.closeDrawer(GravityCompat.START);


				}

				if (position == 4) {
					drawer.closeDrawer(GravityCompat.START);



				}
				if (position == 5) {
					drawer.closeDrawer(GravityCompat.START);



				}

				if (position == 6) {
					drawer.closeDrawer(GravityCompat.START);

				}

			}
		});
	}

	private void setClickOnviewnotification() {
		// TODO Auto-generated method stub
        imageViewnotification.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (drawer.isDrawerVisible(GravityCompat.START)) {
					drawer.closeDrawer(GravityCompat.START);
				}

			}
		});
	}

	private void setClickOnViewPanic() {
		// TODO Auto-generated method stub
        imageViewpanic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (drawer.isDrawerVisible(GravityCompat.START)) {
					drawer.closeDrawer(GravityCompat.START);
				}

			}
		});
	}



	private void setClickListenerOnIvHome() {
		// TODO Auto-generated method stub
		imageView_home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MiHappenings.this, HomeMainActivity.class));
			}
		});
	}

	private void tabHostSetup() {
		// TODO Auto-generated method stub

		// tHost = getTabHost();

		tHost = (TabHost) findViewById(android.R.id.tabhost);
		tWidget = (TabWidget) findViewById(android.R.id.tabs);

		tHost.setup();

		/*tHost.getTabWidget().setDividerDrawable(R.drawable.bg_divider_tab);

		setUpTab("Messages", R.drawable.mess, MessagesTabActivity.class);
		setUpTab("Locations", R.drawable.locationlocator, LocationsTabActivity.class);*/

	}



	private void setOnTouchListenerviewsearch() {
		// TODO Auto-generated method stub
        imageViewsearchn.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View view, MotionEvent event) {

				// TODO Auto-generated method stub
				if (drawer.isDrawerVisible(GravityCompat.START)) {
					drawer.closeDrawer(GravityCompat.START);
				}

				return false;
			}

		});

	}

	private void setClickListenerOnDrawer() {
		// TODO Auto-generated method stub
		drawer.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				offset = slideOffset;

				// Sometimes slideOffset ends up so close to but not quite 1 or
				// 0.
				if (slideOffset >= .995) {
					flipped = true;
					drawerArrowDrawable.setFlip(flipped);
				} else if (slideOffset <= .005) {
					flipped = false;
					drawerArrowDrawable.setFlip(flipped);
				}

				drawerArrowDrawable.setParameter(offset);
			}
		});

	}

	private void setClicklistenerOnIndicator() {
		// TODO Auto-generated method stub
		imV_drawer_Indicator.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (drawer.isDrawerVisible(GravityCompat.START)) {
					drawer.closeDrawer(GravityCompat.START);
				} else {

					drawer.openDrawer(GravityCompat.START);
				}
			}
		});

	}

	private void views() {
		// TODO Auto-generated method stub
		// ***********Drawer*************************//

		drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		imV_drawer_Indicator = (ImageView) findViewById(R.id.drawer_indicator);
		Resources resources = getResources();

		drawerArrowDrawable = new DrawerArrowDrawable(resources);
		drawerArrowDrawable.setStrokeColor(resources.getColor(R.color.white));
		imV_drawer_Indicator.setImageDrawable(drawerArrowDrawable);

		// ***********Tab Host***************************//

		// *******************ListView*********************//

		listView_options = (ListView) findViewById(R.id.listView_options);

		// ******************Views*******************************//



		// *********************ImageView*********************//
		imageViewsearchn = (ImageView) findViewById(R.id.imageViewsearchn);
		imageViewpanic = (ImageView) findViewById(R.id.imageViewpanic);
		imageViewnotification = (ImageView) findViewById(R.id.imageViewnotification);
		imageView_threeBars=(ImageView)findViewById(R.id.imageView_threeBars);



		imageView_home = (ImageView) findViewById(R.id.imageView_home);

		// **********ImageButton***************//

		// /*********TextViews*********************/////
		tvHead_happeningFrag = (TextView) findViewById(R.id.tvHead_happeningFrag);

		/**********linearLayout***********************/

		
	}

	/*private void setUpTab(String labelId, int drawableId, Class<?> c) {

		View tabIndicator = LayoutInflater.from(MyHappenings.this).inflate(R.layout.tab_layout, null, false);
		ImageView icon = (ImageView) tabIndicator.findViewById(R.id.iv_count);
		TextView label = (TextView) tabIndicator.findViewById(R.id.tv_tabHeader);
		label.setTypeface(tf);

		icon.setImageResource(drawableId);
		label.setText(labelId);

		Intent intent = new Intent(this, c);
		TabHost.TabSpec spec = tHost.newTabSpec(labelId);
		spec.setIndicator(tabIndicator);
		spec.setContent(intent);
		tHost.addTab(spec);
	}*/

	/*private void setSelectedTabColor() {

		for (int i = 0; i < tHost.getTabWidget().getChildCount(); i++) {

			tHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#3d4f63"));
			TextView tv = (TextView) tHost.getTabWidget().getChildAt(i).findViewById(R.id.tv_tabHeader); // Unselected
			// Tabs
			tv.setTextColor(Color.WHITE);
		}

		tHost.getTabWidget().getChildAt(tHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#00b787"));
		TextView tv = (TextView) tHost.getTabWidget().getChildAt(tHost.getCurrentTab()).findViewById(R.id.tv_tabHeader); // Unselected
		// Tabs
		tv.setTextColor(Color.WHITE);
	}*/

	/*private void setOnTabListener() {
		// TODO Auto-generated method stub
		tHost.setOnTabChangedListener(new OnTabChangeListener() {

			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				setSelectedTabColor();
			}
		});
	}*/

	// //****************drawerTitles************///
	private ArrayList<String> getDrawerHeaders() {
		// TODO Auto-generated method stub
		ArrayList<String> arr_Headers = new ArrayList<String>();
		arr_Headers.add("Profile");
		arr_Headers.add("Friends");
		arr_Headers.add("Locations");
		arr_Headers.add("Circles");
		// arr_Headers.add("Happenings");
		arr_Headers.add("Panic");
		arr_Headers.add("Notifications");
		arr_Headers.add("Settings");

		return arr_Headers;
	}


}
