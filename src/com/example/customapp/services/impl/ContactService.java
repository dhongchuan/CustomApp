package com.example.customapp.services.impl;

import java.util.ArrayList;

import android.app.IntentService;
import android.content.Intent;

public class ContactService extends IntentService{
	private static final String TAG = "ContactService";
	
	public interface IChangeListener{
		public void onRefreshList(ArrayList<String> contacts);
		public void onRefreshOne(String contact);
	}

	public ContactService() {
		super(TAG);
		
	}

	@Override
	protected void onHandleIntent(Intent intent) {
	}

}
