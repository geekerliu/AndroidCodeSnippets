package com.itheima.lesuo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// 开机启动
		Intent it = new Intent(context, MainActivity.class);
		it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(it);
	}

}
