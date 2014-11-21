package com.allen.themetest.list;

import com.allen.themetest.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListTestItem extends LinearLayout {

	private TextView mText;
	private CheckBox mCheckBox;
	
	public ListTestItem(Context context) {
		this(context, null);
		// TODO Auto-generated constructor stub
	}
	public ListTestItem(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}
	public ListTestItem(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		
	}
	@Override
	protected void onFinishInflate() {
		// TODO Auto-generated method stub
		super.onFinishInflate();
		mText=(TextView) this.findViewById(R.id.name);
		mCheckBox = (CheckBox) this.findViewById(R.id.checkbox);
		mCheckBox.setClickable(false);
		mCheckBox.setFocusable(false);
	}

	public void setText(String name){
		mText.setText(name);
	}
	
	public void setChecked(boolean checked){
		mCheckBox.setChecked(checked);
	}
	public void setActionMode(boolean enable){
		if(enable){
			mCheckBox.setVisibility(View.VISIBLE);
		}else{
			mCheckBox.setVisibility(View.GONE);
		}	
	}	

}
