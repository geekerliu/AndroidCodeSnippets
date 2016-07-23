package com.itheima.smslanjie;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SmsReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		Object[] objects = (Object[]) bundle.get("pdus");
		
		for (Object object : objects) {
			SmsMessage sms = SmsMessage.createFromPdu((byte[])object);
			if(sms.getOriginatingAddress().equals("138438")){
				abortBroadcast();
//				SmsManager.getDefault().sendTextMessage(sms.getOriginatingAddress(), 
//				null, "你是个好人", null, null);
			}
//			System.out.println(sms.getMessageBody());	
		}

	}

}
