package com.allen.themetest;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.allen.themetest.list.ListItemData;
import com.allen.themetest.list.ListTestAdapter;


public class ListTest extends ListActivity {

	private final static String TAG = "ThemeTest";
	private ArrayList<ListItemData> values = new ArrayList<ListItemData> ();
	private ListTestAdapter adapter = null;
	private ActionMode mActionMode;
    private ModeCallback mActionModeListener = new ModeCallback();
    private ListView listView;
    private Context mContext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.list_test);
		
		mContext = this;
		listView = this.getListView();
		intList();
		adapter = new ListTestAdapter(mContext,values);
		
		listView.setAdapter(adapter);
		listView.setOnItemLongClickListener(new ItemLongClickListener());
		listView.setOnItemClickListener(new ItemClickListener());
	}
	
	void intList(){
		
		values.add(new ListItemData(TabBarTest.class,false));
		values.add(new ListItemData(PopupWindowTest.class,false));
	}
	
	
    class ItemLongClickListener implements  ListView.OnItemLongClickListener {

		@Override
		public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
				int arg2, long arg3) {
            mActionMode = startActionMode(mActionModeListener);
            Log.d(TAG, "OnItemLongClickListener");
            adapter.setSelected(arg2);
            int i = adapter.getSelectCount();
            if(i == 0){
            	mActionMode.finish();
            }
            mActionModeListener.setActionModeTitle(i);
            return true;
		}

    };
    
  
    
    class ItemClickListener implements  ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			Log.d(TAG, "ItemClickListener");
			if(mActionMode != null){
				adapter.setSelected(arg2);
	            int i = adapter.getSelectCount();
	            if(i == 0){
	            	mActionMode.finish();
	            }
	            mActionModeListener.setActionModeTitle(i);
				mActionModeListener.setActionModeTitle(adapter.getSelectCount());
			}else{
				ListItemData data = adapter.getItem(arg2);
				Intent intent = new Intent();
				intent.setClassName( data.mClass.getPackage().getName()	, data.mClass.getName());
				mContext.startActivity(intent);
			}
		}


    }; 
    
    private class ModeCallback implements ActionMode.Callback {

    	private View mMultiSelectActionBarView;
    	private Button mSelectionTitle;
    	
    	 
		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			// TODO Auto-generated method stub
			switch (item.getItemId()) {
			  case R.id.delete:
				  adapter.deletSelected();
				  break;
			  default:;
			}
            /// @}
            return true;
		}

		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.menu.list_multi_select_menu_with_selectall, menu);

            if (mMultiSelectActionBarView == null) {
                mMultiSelectActionBarView = LayoutInflater.from(mContext)
                    .inflate(R.layout.list_multi_select_actionbar, null);
                
                mSelectionTitle = (Button)mMultiSelectActionBarView.findViewById(R.id.selection_menu);
                
            }
            
            mode.setCustomView(mMultiSelectActionBarView);
            mSelectionTitle = (Button)mMultiSelectActionBarView.findViewById(R.id.selection_menu);
            setActionModeTitle(0);
            adapter.startActionMode();
            getListView().setLongClickable(false);
			return true;
		}

		@Override
		public void onDestroyActionMode(ActionMode mode) {
			// TODO Auto-generated method stub
			getListView().setLongClickable(true);
			adapter.stopActionMode();
			mActionMode = null;
			
		}

		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			// TODO Auto-generated method stub
            if (mMultiSelectActionBarView == null) {
                ViewGroup v = (ViewGroup)LayoutInflater.from(mContext)
                    .inflate(R.layout.list_multi_select_actionbar, null);
                mode.setCustomView(v);
                
                mSelectionTitle = (Button)mMultiSelectActionBarView.findViewById(R.id.selection_menu);

            }
			
			return true;
		}
		
		public void setActionModeTitle(int count){
			Log.d(TAG, "setActionModeTitle "+ count);
			
			if(count == 0){
	    		mSelectionTitle.setText(R.string.select_item);
	    	}else{
	    		mSelectionTitle.setText
	    			(mContext.getString(R.string.selected_num, count));
	    	}
	    } 	
    }
    
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}	
}
