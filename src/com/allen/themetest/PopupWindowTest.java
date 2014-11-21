package com.allen.themetest;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class PopupWindowTest extends Activity {

	Context mContext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.dialog_test);
		
		mContext = this;
		
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
