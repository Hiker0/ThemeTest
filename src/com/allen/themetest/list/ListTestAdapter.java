package com.allen.themetest.list;

import java.util.ArrayList;

import com.allen.themetest.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


public class ListTestAdapter extends BaseAdapter {

	ArrayList<ListItemData> mList;
	Context mContext;
	boolean actionMode = false;
	
	public ListTestAdapter(Context context, ArrayList<ListItemData> mlist){
		mList = mlist;
		mContext = context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public ListItemData getItem(int position) {
		// TODO Auto-generated method stub
		if(position < mList.size()){
			return mList.get(position);
		}else{
			return null;
		}
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		if(position < mList.size()){
			return position;
		}else{
			return -1;
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ListItemData data = getItem(position);
		
		LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		ListTestItem view;
		
		if(convertView != null){
			view = (ListTestItem) convertView;
		}else{
			view = (ListTestItem) mInflater.inflate(R.layout.list_test_item, parent, false);
		}
		view.setText(data.mClass.getSimpleName());
		view.setChecked(data.mChecked);
		view.setActionMode(actionMode);
		return view;
	}
	
	public void stopActionMode(){
		actionMode = false;
		for(ListItemData data : mList){
			data.mChecked = false;
		}
		this.notifyDataSetChanged();
	}
	
	public void startActionMode(){
		actionMode = true;
		this.notifyDataSetChanged();
	}
	
	public void setSelected(int position){
		ListItemData data = getItem(position);
		if(data.mChecked){
			data.mChecked = false;
		}else{
			data.mChecked = true;
		}
		this.notifyDataSetChanged();
	}
	
	public void setAllSelected(){
		for(ListItemData data : mList){
			data.mChecked = true;
		}
		this.notifyDataSetChanged();
	}
	
	public void deletSelected(){
		for(ListItemData data : mList){
			if(data.mChecked){
				mList.remove(data);
			}
		}
		this.notifyDataSetChanged();
	}   
	
	public int getSelectCount(){
		int count = 0;
		for(ListItemData data : mList){
			if(data.mChecked){
				count++;
			}
		}
		return count;
	}
}
