package com.example.customapp;

import com.example.customapp.fragments.ContactListFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class SlideMenuActivity extends FragmentActivity {
	FragmentManager fm;
    Fragment mFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slide_menu);
		fm = getSupportFragmentManager();
        mFragment = fm.findFragmentById(R.id.content);
        if(mFragment == null){
            mFragment = new ContactListFragment();
            fm.beginTransaction().add(R.id.content, mFragment).commit();
        }
	}
	

}
