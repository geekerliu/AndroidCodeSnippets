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
        
        // 这个对象是只读的
//        Bitmap bmSrc = BitmapFactory.decodeFile("sdcard/photo3.jpg");
        Bitmap bmSrc = BitmapFactory.decodeResource(getResources(), R.drawable.photo);
        
        //创建图片的副本
        //1.在内存中创建一个与原图大小一模一样的的bitmap对象
        Bitmap bmCopy = Bitmap.createBitmap(bmSrc.getWidth(), bmSrc.getHeight(), bmSrc.getConfig());
        
        //2.创建画笔对象
        Paint paint = new Paint();
        
        //3.创建画板对象，把白纸铺在画板上
        Canvas canvas = new Canvas(bmCopy);
        
        //4.开始作画
        canvas.drawBitmap(bmSrc, new Matrix(), paint);
        
        ImageView iv_src = (ImageView) findViewById(R.id.iv_src);
        ImageView iv_copy = (ImageView) findViewById(R.id.iv_copy);
        iv_src.setImageBitmap(bmSrc);
        iv_copy.setImageBitmap(bmCopy);
    }
}
