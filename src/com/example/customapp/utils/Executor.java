package com.example.customapp.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.example.customapp.interactor.IInteractor;

public class Executor {
	private static final int CORE_POOL_SIZE = 3;
	private static final int MAX_POOL_SIZE = 5;
	private static final int KEEP_ALIVE_TIME = 120;
	private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

	private BlockingQueue<Runnable> mWorkQueue;
	private ThreadPoolExecutor mWorkExecutor;

	public Executor() {
		mWorkQueue = new LinkedBlockingQueue<Runnable>();
		mWorkExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, mWorkQueue);
	}
	
	public void submit(IInteractor interactor){
		mWorkExecutor.submit(interactor);
	}

}
