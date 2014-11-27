package com.allen.themetest;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;



public class PopupWindowTest extends Activity {

	Context mContext;
	Spinner mSpinner;
	Button mPopupButton;
	PopupMenu popup;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.dialog_test);
		
		mContext = this;
		
		String[] mItems = getResources().getStringArray(R.array.viewby_items_easy);
		mSpinner = (Spinner) this.findViewById(R.id.spinner);
		ArrayAdapter<String> _Adapter=new ArrayAdapter<String>(this.mContext ,android.R.layout.simple_spinner_item, mItems);
	     
		mSpinner.setAdapter(_Adapter);
		mSpinner.setOnItemSelectedListener(mOnSpinnerItemSelectedListener);
		
		
		mPopupButton = (Button) this.findViewById(R.id.create_popup);
		mPopupButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
		        
		        if (null == popup) {
		        	popup = constructPopupMenu(v); 
		        }
		        popup.show();
			}
		});
		

		
		Button button = (Button) this.findViewById(R.id.createbutton);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LayoutInflater inflater = getLayoutInflater();
				View layout = inflater.inflate(R.layout.dialog ,(ViewGroup) findViewById(R.id.dialog));
				new AlertDialog.Builder(mContext).setTitle("自定义布局").setView(layout)
					.setPositiveButton("确定", null)
					.setIconAttribute(android.R.attr.alertDialogIcon)
					.setNegativeButton("取消", null).show();
			}
		});
		
	}
	 private Spinner.OnItemSelectedListener  mOnSpinnerItemSelectedListener =
	    		new Spinner.OnItemSelectedListener(){

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						((TextView) arg1).setTextColor(0xffff00ff);
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
						
					}
		 
	 };
	
   private PopupMenu constructPopupMenu(View anchorView) {

        final PopupMenu popupMenu = new PopupMenu(this, anchorView);
        popupMenu.inflate(R.menu.main_activity);
        popupMenu.setOnMenuItemClickListener(listener);
        
        return popupMenu;
    }
   PopupMenu.OnMenuItemClickListener listener = new  PopupMenu.OnMenuItemClickListener(){

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		// TODO Auto-generated method stub
		return false;
	}
	   
   };
	   
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater =  getMenuInflater();
		inflater.inflate(R.menu.main_activity, menu);
		return true;
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		Intent intent = new Intent("update_status_bar_transparent");
		
		sendBroadcast(intent);
		
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}



}
