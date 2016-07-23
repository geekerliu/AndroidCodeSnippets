package com.itheima.sdlistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SDStatusReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		if ("android.intent.action.MEDIA_MOUNTED".equals(action)) {
			Toast.makeText(context, "SD MEDIA_MOUNTED", Toast.LENGTH_SHORT)
					.show();
		} else if ("android.intent.action.MEDIA_REMOVED".equals(action)) {
			Toast.makeText(context, "SD MEDIA_REMOVED", Toast.LENGTH_SHORT)
					.show();
		} else if ("android.intent.action.MEDIA_UNMOUNTED".equals(action)) {
			Toast.makeText(context, "SD MEDIA_UNMOUNTED", Toast.LENGTH_SHORT)
					.show();
		}

	}

}
