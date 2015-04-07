package com.example.customapp;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

public class WinXinActionBarProvider extends ActionProvider {

	public WinXinActionBarProvider(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateActionView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onPrepareSubMenu(SubMenu subMenu) {
		subMenu.clear();
		subMenu.add("ɨһɨ").setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				Toast.makeText(getContext(), "ɨһɨ", 300).show();;
				return false;
			}
		});
	}
	
	@Override  
    public boolean hasSubMenu() {  
        return true;  
    }  

}
