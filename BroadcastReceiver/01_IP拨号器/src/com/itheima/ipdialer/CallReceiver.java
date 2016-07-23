package com.itheima.ipdialer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class CallReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		System.out.println("接收到了打电话的广播");
		String number = getResultData();
		if (number.startsWith("0")) {
			SharedPreferences sp = context.getSharedPreferences("ip",
					Context.MODE_PRIVATE);
			String ipNumber = sp.getString("ipNumber", "");

			number = ipNumber + number;
			setResultData(number);

			abortBroadcast();
		}
	}
}
