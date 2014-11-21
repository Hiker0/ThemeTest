package com.allen.themetest;


import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;



public class TabBarTest extends Activity implements ActionBar.TabListener{

	Context mContext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.tabbar_test);
		
		mContext = this;
		
//        int flags = WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
//				    | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//                ;
//        WindowManager.LayoutParams lp = getWindow().getAttributes();
//        lp.flags |= flags;
//        getWindow().setAttributes(lp);
		
		initTabBar();
			
		
	}
	
    void initTabBar(){
    	
    	ActionBar actionbar = this.getActionBar();
    	actionbar.setDisplayOptions(0);

    	actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
    	
    	for( int i = 0; i <4; i++  ){
    		
    		Tab tab = actionbar.newTab();
    		
    		tab.setCustomView(R.layout.actionbar_custom_tab);
        	TextView title = (TextView)tab.getCustomView().findViewById(R.id.tab_custom_view_text);
        	ImageView icon = (ImageView)tab.getCustomView().findViewById(R.id.tab_custom_view_icon);
        	    
        	switch(i){
        	case 0:
//        		tab.fragment = mDialpadFragment;
        		title.setText(R.string.actiontitle_dialpad);
        		icon.setImageResource(R.drawable.action_bar_tab_icon_keypad);
//        		tab.setIcon(R.drawable.action_bar_tab_icon_keypad);
//        		tab.setText(R.string.actiontitle_dialpad);
        		break;
        	case 1:
//        		tab.fragment = mPhoneFavoriteFragment;
        		title.setText(R.string.actiontitle_history);
        		icon.setImageResource(R.drawable.action_bar_tab_icon_logs);
//        		tab.setIcon(R.drawable.action_bar_tab_icon_logs);
//        		tab.setText(R.string.actiontitle_history);
        		break;
        	case 2:
//        		tab.fragment = mPhoneFavoriteFragment;
        		title.setText(R.string.actiontitle_favourite);
        		icon.setImageResource(R.drawable.action_bar_tab_icon_favorites);
//        		tab.setIcon(R.drawable.action_bar_tab_icon_favorites);
//        		tab.setText(R.string.actiontitle_favourite);
        		break;
        	case 3:
        		title.setText(R.string.actiontitle_contact);
        		icon.setImageResource(R.drawable.action_bar_tab_icon_contacts);
//        		tab.setIcon(R.drawable.action_bar_tab_icon_contacts);
//        		tab.setText(R.string.actiontitle_contact);
        		break;        		
        	}
//    		
        	tab.setTabListener(this);
        	actionbar.addTab(tab);
    	};
    	
    	
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


	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}
