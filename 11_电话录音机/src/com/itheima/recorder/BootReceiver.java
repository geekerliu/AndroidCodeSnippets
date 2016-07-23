package com.itheima.recorder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// 监听开机启动的广播接收者
public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent it = new Intent(context, RecorderService.class);
		// 服务不需要创建任务栈
		context.startService(it);
	}

}
