package com.sns.micircle.setting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.sns.micircle.R;
import com.sns.micircle.adapter.FaqsListAdapter;

public class FAQSActivity extends Activity{

	ImageView ivFaqLeft;
	ExpandableListView expanListViewFAQ;
	FaqsListAdapter listAdapter;
	List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_faqs);
		
		//declaring Views...
		view();
		
		// preparing list data
        prepareListData();
		
		setClickListeneronBackArrow();
		
		 listAdapter = new FaqsListAdapter(FAQSActivity.this, listDataHeader, listDataChild);
		 
	        // setting list adapter
	        expanListViewFAQ.setAdapter(listAdapter);
	 
	}
	/*
     * Preparing the list data
     */
	private void prepareListData() {
		// TODO Auto-generated method stub
		
	        listDataHeader = new ArrayList<String>();
	        listDataChild = new HashMap<String, List<String>>();
	 
	        // Adding child data
	        listDataHeader.add("mi-happening");
	        listDataHeader.add("Circle");
	        listDataHeader.add("Location");
	        listDataHeader.add("Panic");
	        listDataHeader.add("Friends");
	        listDataHeader.add("Notifications");
	        
	        // Adding child data
	        List<String> happening = new ArrayList<String>();
	        happening.add("Q: How do I see new messages? \n");
	        
	 
	        List<String> circle = new ArrayList<String>();
	        circle.add("Q: How to Create Circle? \nA : At the bottom of Circle-home page, Click on 'Create Circle'");
	        circle.add("Q: What are Privacy Type? \nA: Circle have two privacy features - Public and Private. All data under Private Circles is not shared with any third party like marketing, advertisements, etc.");
	        circle.add("Q: Image upload for Circle? \n");
	        circle.add("Q: Share a location within Circle? \nA: User can share a location within the circle while creating circle or thru -Location '+'  tab at the Landing page, Once a location is shared in the circle then User{s} check-in and check-out at the shared location is captured and shared with member.");
	        circle.add("Q: Add members to Circle? \nA: User can add friends within the circle while creating circle or thru -Member '+'  tab at the Landing page, Once a friend is added his/her check-in and check-out at the shared location in the circle is captured and shared in the circle besides Members can send and receive messages.");
	        circle.add("Q: What is Circle Age? \nA : User can create circle with defined life, at the selected date Circle will be removed from all members. Admin User can update Circle-Age thru Settings tab at the Landing page");
	 
	        List<String> location = new ArrayList<String>();
	        location.add("Q:  How to create a location? \nA :  User can create/add their favorite or frequently visited locations by clicking on 'Add your locations'");
	        location.add("Q:  What is location tracking? \nA : Location Geo-Fencing is not enabled till its shared with a friend or in a circle");
	        location.add("Q: How to get driving direction to or from this locaiton? \nA : Navigate to Location Landing Page, look for 'Track' ");
	        location.add("Q: What  is nearby places / How do I find out nearby places to my favorite locations ? \nA : On Location Landing Page, click on 'Go to Nearby Places', which will navigate to page where predefined choices area available and radius seek bar at the bottom to choose the range for finding place. User can click on 'Map/List' small circle at the bottom and each result will have details like phone number, website if entered by the owner or administrator of the location.");
	        location.add("Q : What is activities / How do I check loation's check-in and check-out activities of friends / circles it shared with ? \nA : Navigate to 'Activities' on 'Location Landing page' to see check-in and check-out activities for members shared thru circle or directly");
	        location.add("Q : How do I check with whom locations is shared and unshare?");
	        location.add("Q: How do I share my favorite location with friends and with Cricles? \nA : on Location Landing page by going to Share or Unshare at the bottom of the page.");
	        
	        List<String> panic = new ArrayList<String>();
	        panic.add("Q: What is Panic ? \nA : Panic allows User to reach other pre-defined members for help in case of emergency situations like medical, accident, burglary, threat, etc. ");
	        panic.add("Q: How do I know if someone has generated Panic in my circle? \nA :  User can add members to Panic Circle thru Circle Home Page or by going to Panic Circle Landing Page : Member tab");
	        panic.add("Q: How do I add members to my Panic Circle? ");
	        panic.add("Q: How do I respond to Panic?");
	        panic.add("Q: How do I know if someone is acknowledged to my Panic and coming for help? \nA : As soon as member of Panic Circle acknowledge to help, notifications goes to Initiator and all members for acceptance and member can check to Particular Panic Landing Page data tab on who has accepted and distance away from panic locatoin");
	        panic.add("Q: How do I check distance of help from panic locaiton ? \nA : Panic Landing Page data-tab shows members who have acknowledged the panic and distance from panic location");
	        panic.add("Q: Can I check realtime tracking of help  ? \nA : Initiation and acknowledgers can go to Map tab of Panic Landing page and see the real-time tracking");
	        
	        List<String> friends = new ArrayList<String>();
	        friends.add("Q: How to add friends in the circle");
	        friends.add("Q: How to removed friend from my list ?");
	        friends.add("Q: How do I removed friend");
	        friends.add("Q: what is manage friend?");
	        friends.add("Q : What do I get in suggestion ?");
	        friends.add("Q : my contact list");
	        
	        List<String> notifications = new ArrayList<String>();
	        notifications.add("mi-Notifications");
	        notifications.add("Push Notification");
	        notifications.add("Enable/Disable Push Notifications");
	        
	        listDataChild.put(listDataHeader.get(0), happening); // Header, Child data
	        listDataChild.put(listDataHeader.get(1), circle);
	        listDataChild.put(listDataHeader.get(2), location);
	        listDataChild.put(listDataHeader.get(3), panic);
	        listDataChild.put(listDataHeader.get(4), friends);
	        listDataChild.put(listDataHeader.get(5), notifications);
	    
	}

	private void setClickListeneronBackArrow() {
		// TODO Auto-generated method stub
		ivFaqLeft.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});
	}

	private void view() {
		// TODO Auto-generated method stub
		ivFaqLeft=(ImageView)findViewById(R.id.ivFaqLeft);
		expanListViewFAQ= (ExpandableListView)findViewById(R.id.expandableListView_faq);
		
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}
}
