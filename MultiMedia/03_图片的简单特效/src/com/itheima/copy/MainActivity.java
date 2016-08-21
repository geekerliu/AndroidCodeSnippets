package com.itheima.copy;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		Bitmap bmSrc = BitmapFactory.decodeFile("sdcard/photo3.jpg");
		Bitmap bmSrc = BitmapFactory.decodeResource(getResources(), R.drawable.photo);
		Bitmap bmCopy = Bitmap.createBitmap(bmSrc.getWidth(),
				bmSrc.getHeight(), bmSrc.getConfig());
		Paint paint = new Paint();
		Canvas canvas = new Canvas(bmCopy);
		Matrix mt = new Matrix();

		// 以左上角为原点平移
		// mt.setTranslate(20, 40);
		// Set the matrix to scale by sx and sy
		// mt.setScale(0.5f, 0.5f);
		// mt.setScale(0.5f, 0.5f, bmCopy.getWidth() / 2, bmCopy.getHeight() /
		// 2);
		// 旋转，后面两个参数指定旋转的中心点
//		mt.setRotate(45, bmCopy.getWidth() / 2, bmCopy.getHeight() / 2);

		// Set the matrix to scale by sx and sy
//		 mt.setScale(-1, 1);
		// mt.postTranslate(bmCopy.getWidth(), 0);
		
		// 每个像素乘以一个系数，在旋转
		mt.setScale(1, -1);
		mt.postTranslate(0, bmCopy.getHeight());
		canvas.drawBitmap(bmSrc, mt, paint);

		ImageView iv_src = (ImageView) findViewById(R.id.iv_src);
		ImageView iv_copy = (ImageView) findViewById(R.id.iv_copy);
		iv_src.setImageBitmap(bmSrc);
		iv_copy.setImageBitmap(bmCopy);
	}

}
