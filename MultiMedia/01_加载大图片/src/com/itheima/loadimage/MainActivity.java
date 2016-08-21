package com.itheima.loadimage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	private int calculateScaleSize(int originalWidth, int originalHeight,
			int destWidth, int destHeight) {
		// 这里采用向上取整，比如如果图片是屏幕的1.5倍大，
		// 如果取1的话还是可能会崩溃，所以此时应该向上取整为2
		int scaleWidth = (int) Math.ceil(originalWidth * 1.0f / destWidth);
		int scaleHeight = (int) Math.ceil(originalHeight * 1.0f / destHeight);
		System.out.println(Math.max(scaleHeight, scaleWidth)+"");
		return Math.max(scaleHeight, scaleWidth);
	}

	public void click(View v) {
		// 获取图片的宽高，但是不解析图片
		Options opt = new Options();
		opt.inJustDecodeBounds = true;
//		BitmapFactory.decodeFile("sdcard/dog.jpg", opt);
		BitmapFactory.decodeResource(getResources(), R.drawable.dog, opt);
		int imageWidth = opt.outWidth;
		int imageHeight = opt.outHeight;

		// 获取屏幕的宽高
		Display dp = getWindowManager().getDefaultDisplay();
		int screenWidth = dp.getWidth();
		int screenHeight = dp.getHeight();

		// 缩放图片
		opt.inSampleSize = calculateScaleSize(imageWidth, imageHeight,
				screenWidth, screenHeight);
		opt.inJustDecodeBounds = false;
//		Bitmap bm = BitmapFactory.decodeFile("sdcard/dog.jpg", opt);
		Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.dog, opt);
		// 使用缩放后的图片显示在屏幕上
		ImageView iv = (ImageView) findViewById(R.id.iv);
		iv.setImageBitmap(bm);
	}
}
