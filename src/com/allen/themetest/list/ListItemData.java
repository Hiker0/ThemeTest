package com.allen.themetest.list;


public class ListItemData {
	public Class<?> mClass = null;
	public boolean mChecked = false;
	
	public ListItemData(Class<?> mclass,boolean checked){
		mClass = mclass;
		mChecked = checked;
	}
	
	public Class<?> getItemClass(){
		return mClass;
	}

	public boolean getChecked(){
		return mChecked;
	}
}
