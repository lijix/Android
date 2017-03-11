package com.example.day0701;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 来接受外界的广播
 * @author Administrator
 *
 */
public class MyReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("TAG", "来电话了-----");
	}

}
