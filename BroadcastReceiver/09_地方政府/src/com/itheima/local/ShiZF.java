package com.itheima.local;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ShiZF extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String text = getResultData();
		System.out.println("�������յ��ļ���" + text);
		abortBroadcast();
	}

}
