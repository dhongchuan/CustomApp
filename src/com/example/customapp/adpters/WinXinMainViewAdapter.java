package com.example.customapp.adpters;

import com.example.customapp.fragments.ContactListFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class WinXinMainViewAdapter extends FragmentStatePagerAdapter{

	public WinXinMainViewAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		Fragment fm = new ContactListFragment();
		return fm;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	
	

}
