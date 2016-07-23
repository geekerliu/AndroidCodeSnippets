package com.itheima.startservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intent = new Intent(this, MyService.class);
	}

	public void click(View v) {
		// 开启服务
		startService(intent);
	}

	public void click2(View v) {
		// 停止服务
		stopService(intent);
	}

}
