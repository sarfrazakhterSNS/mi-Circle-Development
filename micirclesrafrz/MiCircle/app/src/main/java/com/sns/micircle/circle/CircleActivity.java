package com.sns.micircle.circle;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
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

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static android.view.Gravity.LEFT;

/**
 * Created by Vikas on 10/13/2016.
 */

public class CircleActivity extends Activity {

    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    RelativeLayout relativeLayoutbottom;
    TextView tvHead_happeningFrag,tv_dialog_private, tv_dialog_pulic;
    ArrayList<String> arr_Headers;
    DrawerArrowDrawable drawerArrowDrawable;
    DrawerLayout drawer;
    ImageView imV_drawer_Indicator;
    float offset;
    boolean flipped;
    ListView listView_options;


    //drawer item....
    ImageView imageViewpanic, imageViewnotification, imageViewsearchn, imageView8, imageView1, imageViewmore, button_left, imageView_threeBars, imageViewGrid_view, imageVi_List, imageView_home;
    int[] image = {R.drawable.profiledrawerwhite, R.drawable.headerfriend, R.drawable.headerlocation, R.drawable.circledrawertemp, R.drawable.panicheadern, R.drawable.headernotifi, R.drawable.headerseeting,};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        views();

        setDefaultFrag();

        setClickOnViewPanic();

        setClickOnviewnotification();

        setClickListenerOnIvHome();

        setClicklistenerOnIndicator();

        setClickListenerOnDrawer();

        setOnTouchListenerviewsearch();

        setClickListnerOnDrawerListItem();

        setClickListeneronThreeBars();

        setClickOnrelativeLayoutbottom();

        arr_Headers = getDrawerHeaders();

        DarawerListAdapter mhlistadapter = new DarawerListAdapter(CircleActivity.this, image, arr_Headers);

        listView_options.setAdapter(mhlistadapter);
    }

    private void setClickOnrelativeLayoutbottom() {

        relativeLayoutbottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



               final Dialog dialog = new Dialog(CircleActivity.this);

                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                dialog.setContentView(R.layout.customdilog_circle);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

                dialog.setCanceledOnTouchOutside(true);

                ImageView Private_Circle = (ImageView) dialog.findViewById(R.id.Private_Circle);

                tv_dialog_private = (TextView) dialog.findViewById(R.id.tv_dialog_private);
                tv_dialog_pulic = (TextView) dialog.findViewById(R.id.tv_dialog_pulic);

                /*Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(), "font/OpenSans-Regular.ttf");
                tv_dialog_private.setTypeface(tf);
                tv_dialog_pulic.setTypeface(tf);*/

                Private_Circle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                        callActivity();
                    }

                    private void callActivity() {
                        // TODO Auto-generated method stub

                        Intent intent = new Intent(CircleActivity.this, Create_Private_Circle.class);

                        startActivity(intent);

                    }

                });

                ImageView Public_Circle = (ImageView) dialog.findViewById(R.id.Public_Circle);
                Public_Circle.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub

                        dialog.dismiss();
                        // ReplaceFragment();
                        callActivity();

                    }

                    private void callActivity() {
                        // TODO Auto-generated method stub

                        Intent intent = new Intent(CircleActivity.this, Create_Public_Circle.class);

                        startActivity(intent);

                    }
                });



                dialog.show();

            }
        });
    }

    private void setDefaultFrag() {
        // TODO Auto-generated method stub

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Default_Circle_Activity fragment = new Default_Circle_Activity();
        fragmentTransaction.add(R.id.fragment_MainCointer, fragment);
        fragmentTransaction.commit();

    }


    private void setClickOnViewPanic() {
        // TODO Auto-generated method stub
        imageViewpanic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }

            }
        });
    }

    private void setClickOnviewnotification() {
        // TODO Auto-generated method stub
        imageViewnotification.setOnClickListener(new View.OnClickListener() {

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
        imageView_home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(CircleActivity.this, HomeMainActivity.class));
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
        imV_drawer_Indicator.setOnClickListener(new View.OnClickListener() {
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

    private void setOnTouchListenerviewsearch() {
        // TODO Auto-generated method stub
        imageViewsearchn.setOnTouchListener(new View.OnTouchListener() {

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

    private void setClickListnerOnDrawerListItem() {
        // TODO Auto-generated method stub
        listView_options.setOnItemClickListener(new AdapterView.OnItemClickListener() {

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

    private void setClickListeneronThreeBars() {

        imageView_threeBars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(CircleActivity.this, v);
                //Inflating the Popup using xml file
                setForceShowIcon(popup);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {

                        if (item.getTitle().equals("Feedback")) {
                            startActivity(new Intent(CircleActivity.this, FeedBackActivity.class));

                            return true;
                        } else if (item.getTitle().equals("FAQ's")) {
                            startActivity(new Intent(CircleActivity.this, FAQSActivity.class));

                            return true;

                        } else if (item.getTitle().equals("Setting")) {
                            startActivity(new Intent(CircleActivity.this,MiSetting.class));

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

    // //****************drawerTitles************///
    private ArrayList<String> getDrawerHeaders() {
        // TODO Auto-generated method stub
        ArrayList<String> arr_Headers = new ArrayList<String>();
        arr_Headers.add("Profile");
        arr_Headers.add("Friends");
        arr_Headers.add("Locations");
        arr_Headers.add("Circles");
        arr_Headers.add("Happenings");
        arr_Headers.add("Panic");
        //arr_Headers.add("Notifications");
        arr_Headers.add("Settings");

        return arr_Headers;
    }


    private void views() {
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
        imageView_threeBars = (ImageView) findViewById(R.id.imageView_threeBars);


        imageView_home = (ImageView) findViewById(R.id.imageView_home);

        // **********ImageButton***************//

        // /*********TextViews*********************/////
        tvHead_happeningFrag = (TextView) findViewById(R.id.tvHead_happeningFrag);

        relativeLayoutbottom =(RelativeLayout)findViewById(R.id.relativeLayoutbottom);



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
}