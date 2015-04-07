package com.example.customapp.customviews;

import com.example.customapp.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

public class ChangeColorButton extends View {
	private String mText;
	private Rect mTextRect;
	private Rect mIconBound;
	
	private Paint mTextPaint;
	private Bitmap mIconBitmap;
	
	private Bitmap mBitmap;
	private Canvas mCanvas;
	private Paint mPaint;
	
	private int mAlpha = 255;
	private int mColor;
	
	private boolean isSelect;

	public ChangeColorButton(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mIconBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_contact);
		mText = "发现";
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ChangeColorButton);
		int count = a.getIndexCount();
		for(int i = 0; i < count; i++){
			int attr = a.getIndex(i);
			switch (attr) {
			case R.styleable.ChangeColorButton_menu_icon:
				BitmapDrawable drawable = (BitmapDrawable) a.getDrawable(attr);
				mIconBitmap = drawable.getBitmap();
				break;
			case R.styleable.ChangeColorButton_menu_text:
				String text = a.getString(attr);
				mText = text;
			default:
				break;
			}
		}
		a.recycle();
		init();
	}

	public ChangeColorButton(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}

	public ChangeColorButton(Context context) {
		this(context, null);
		// TODO Auto-generated constructor stub
	}
	
	private void init(){
		
		mTextPaint = new Paint();
		mTextPaint.setAlpha(10);
//		mTextPaint.setColor(getResources().getColor(android.R.color.black));
		mTextPaint.setTextSize(10);
		mTextRect = new Rect();
		mTextPaint.getTextBounds(mText, 0, mText.length(), mTextRect);
		
		mColor = getResources().getColor(android.R.color.holo_red_light);
		setTargetAlpha();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		
		int h = getMeasuredHeight() - getPaddingBottom() - getPaddingTop() - mTextRect.height();
		int w = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
		int iconSize = Math.min(h, w);
		
		int left = getMeasuredWidth()/2 - iconSize/2;
		int top = getMeasuredHeight()/2 - (mTextRect.height()+iconSize)/2;
		mIconBound = new Rect(left, top, left+iconSize, top+iconSize);
		
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
//		canvas.drawText(mText, mTextRect.left, mTextRect.right, mTextPaint);
		//绘制原ICON
		canvas.drawBitmap(mIconBitmap, null, mIconBound, null);
		//绘制目标ICON
		setTargetBitmap();
		canvas.drawBitmap(mBitmap, 0, 0, null);
		
		//绘制文字
		int textLeft = getMeasuredWidth() / 2 - mTextRect.width() / 2;
		int textTop = mIconBound.bottom + mTextRect.height();
		
		//绘制原文本
		mTextPaint.setColor(0xff333333);
		mTextPaint.setAlpha(255-mAlpha);
		canvas.drawText(mText, textLeft, textTop, mTextPaint);
		
		//绘制变色文本
		mTextPaint.setColor(mColor);
		mTextPaint.setAlpha(mAlpha);
		canvas.drawText(mText, textLeft, textTop, mTextPaint);
	}

	private void setTargetBitmap() {
		mBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Config.ARGB_8888);
		mCanvas = new Canvas(mBitmap);
		mPaint = new Paint();
		mPaint.setAlpha(100);
		mPaint.setColor(getResources().getColor(android.R.color.holo_red_light));
		
		mCanvas.drawRect(mIconBound, mPaint);
		mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
		mPaint.setAlpha(mAlpha);
		mCanvas.drawBitmap(mIconBitmap, null, mIconBound, mPaint);
	}

	

	private void setTargetAlpha() {
		if(isSelect){
			mAlpha = 255;
		}else{
			mAlpha = 1;
		}
	}

	private void invalidateView() {
		// TODO Auto-generated method stub
		invalidate();
	}
	
	public boolean isSelect() {
		return isSelect;
	}

	public void setSelect(boolean isSelect) {
		this.isSelect = isSelect;
		setTargetAlpha();
		invalidateView();
	}

	public void toggle(){
		isSelect = !isSelect;
		setTargetAlpha();
		invalidateView();
	}

}
