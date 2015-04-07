package com.example.customapp.customviews;

import android.app.Fragment;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;

public class SlidingMenuLayout extends HorizontalScrollView{
	private ViewGroup mparent;
	private ViewGroup mMenu;
	private ViewGroup mContent;
	
	private int mScreenWidth;
	private int mMenuPaddingRight;
	private int mMenuWidth;

	public SlidingMenuLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init();
	}

	public SlidingMenuLayout(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}

	public SlidingMenuLayout(Context context) {
		this(context, null);
		// TODO Auto-generated constructor stub
	}
	
	private void init(){
		WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics dm = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(dm);
		mScreenWidth = dm.widthPixels;
		Log.d("ScreenWidth", String.valueOf(mScreenWidth));
		mMenuPaddingRight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, dm);
		
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		mparent = (ViewGroup) getChildAt(0);
		mMenu = (ViewGroup) mparent.getChildAt(0);
		mContent = (ViewGroup) mparent.getChildAt(1);
		
		mMenuWidth = mScreenWidth - mMenuPaddingRight;
		mMenu.getLayoutParams().width = mMenuWidth;
		mContent.getLayoutParams().width = mScreenWidth;
		
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		super.onLayout(changed, l, t, r, b);
		if(changed)
			this.scrollTo(mMenuWidth, 0);
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		// TODO Auto-generated method stub
		super.onScrollChanged(l, t, oldl, oldt);
		float scale = (l+mMenuPaddingRight) * 1.0f / mScreenWidth;		
		float contentScale = 0.7f + 0.3f * scale;
		float leftScale = 1.0f - 0.3f * scale;
		float alpha = 0.6f+0.4f*(1-scale);
		
		Log.d("l", String.valueOf(l));
		Log.d("scale", String.valueOf(scale));
		Log.d("contentScale", String.valueOf(contentScale));
		mContent.setScaleX(contentScale);
		mContent.setScaleY(contentScale);
		mContent.setPivotX(0);
		mContent.setPivotY(mContent.getHeight()/2);
		
		mMenu.setTranslationX(mScreenWidth * scale*0.7f);
		mMenu.setScaleX(leftScale);
		mMenu.setScaleY(leftScale);
		mMenu.setAlpha(alpha);
		}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		switch (ev.getAction()) {
		case MotionEvent.ACTION_UP:
			int x = getScrollX();
			int m = mMenuWidth / 2;
			if(x >= m){
				this.smoothScrollTo(mMenuWidth, 0);
			}else{
				this.smoothScrollTo(0, 0);
			}
			return true;

		default:
			break;
		}
		return super.onTouchEvent(ev);
	}
	
	

}
