package com.example.customapp.utils;

import com.example.customapp.interactor.PostExecutionThread;

import android.os.Handler;
import android.os.Looper;

public class PostUIExecution implements PostExecutionThread{
	private Handler mHandler;
	
	public PostUIExecution(){
		mHandler = new Handler(Looper.getMainLooper());
	}
	
	public void post(Runnable runnable){
		mHandler.post(runnable);
	}

}
