package com.sns.micircle.adapter;

import java.util.HashMap;
import java.util.List;

import com.sns.micircle.R;
import com.sns.micircle.setting.FAQSActivity;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class FaqsListAdapter extends BaseExpandableListAdapter{

	
	Context context;
	
	private List<String> nlistDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> nlistDataChild;
    
	public FaqsListAdapter(FAQSActivity faqsActivity,
			List<String> listDataHeader,
			HashMap<String, List<String>> listDataChild) {
		// TODO Auto-generated constructor stub
		this.context= faqsActivity;
		this.nlistDataHeader=listDataHeader;
		this.nlistDataChild=listDataChild;
		
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return nlistDataHeader.size();
    
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return nlistDataChild.get(this.nlistDataHeader.get(groupPosition))
                .size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return nlistDataHeader.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return nlistDataChild.get(this.nlistDataHeader.get(groupPosition)).get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		 String headerTitle = (String) getGroup(groupPosition);
	        if (convertView == null) {
	            LayoutInflater infalInflater = (LayoutInflater) context
	                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            convertView = infalInflater.inflate(R.layout.faq_list_group, null);
	        }
	 
	        TextView lblListHeader = (TextView) convertView
	                .findViewById(R.id.tv_list_group);
	        lblListHeader.setTypeface(null, Typeface.BOLD);
	        lblListHeader.setText(headerTitle);
	 
	        return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		 final String childText = (String) getChild(groupPosition, childPosition);
		 
	        if (convertView == null) {
	            LayoutInflater infalInflater = (LayoutInflater) context
	                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            convertView = infalInflater.inflate(R.layout.faq_list_item, null);
	        }
	 
	        TextView txtListChild = (TextView) convertView
	                .findViewById(R.id.tv_list_child);
	 
	        txtListChild.setText(childText);
	        return convertView;
	
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}

}
