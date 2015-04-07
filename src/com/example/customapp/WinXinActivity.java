package com.example.customapp;

import java.util.ArrayList;

import com.example.customapp.adpters.WinXinMainViewAdapter;
import com.example.customapp.customviews.ChangeColorButton;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class WinXinActivity extends ActionBarActivity implements OnClickListener{

	private ArrayList<ChangeColorButton> mButtons;
	private int mCurrentIndex;
	private ViewPager viewPager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weinxin);
		getActionBar().setDisplayShowHomeEnabled(false);
		viewPager = (ViewPager) findViewById(R.id.container);
		viewPager.setAdapter(new WinXinMainViewAdapter(getSupportFragmentManager()));
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				mCurrentIndex = arg0;
				changeSelectButton();
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		mCurrentIndex = 0;
		mButtons = new ArrayList<ChangeColorButton>(3);
		ChangeColorButton firstButton = (ChangeColorButton) findViewById(R.id.one);
		firstButton.setOnClickListener(this);
		firstButton.setSelect(true);
		mButtons.add(firstButton);
		firstButton = (ChangeColorButton) findViewById(R.id.two);
		firstButton.setOnClickListener(this);
		firstButton.setSelect(false);
		mButtons.add(firstButton);
		firstButton = (ChangeColorButton) findViewById(R.id.three);
		firstButton.setOnClickListener(this);
		firstButton.setSelect(false);
		mButtons.add(firstButton);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.one:
			mCurrentIndex = 0;
			break;
		case R.id.two:
			mCurrentIndex = 1;
			break;
		case R.id.three:
			mCurrentIndex = 2;
			break;

		default:
			break;
		}
		viewPager.setCurrentItem(mCurrentIndex,true);
		changeSelectButton();
	}

	private void changeSelectButton() {
		// TODO Auto-generated method stub
		ChangeColorButton currentSelectButton;
		for(int i = 0; i < 3; i++){
			currentSelectButton = mButtons.get(i);
			if(i == mCurrentIndex)
				currentSelectButton.setSelect(true);
			else
				currentSelectButton.setSelect(false);
		}
	}
}
