package com.example.day0702_outgoingreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class OutGoingCallReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		String numberPhone=getResultData();
		Log.i("TAG", "�����绰�ǣ�"+numberPhone);
		//��������������ĵ绰
		setResultData("791"+numberPhone);
	}

}
