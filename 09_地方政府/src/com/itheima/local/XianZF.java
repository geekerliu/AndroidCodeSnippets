package com.itheima.local;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class XianZF extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String text = getResultData();
		System.out.println("" + text);
	}

}
