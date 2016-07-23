package com.itheima.center;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void click(View v) {
    	Intent intent = new Intent();
    	intent.setAction("com.itheima.fdm");
    	// 发送有序广播
    	sendOrderedBroadcast(intent, null, new MyReceiver(), null, 0, "ÿ�˷�100�����", null);
    }
    
    class MyReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			String text = getResultData();
			System.out.println("��̰���յ��ļ���" + text);
		}
    	
    }
}
