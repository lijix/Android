package com.example.day0102_service;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("TAG","Service---onCreate");
	}

	public void onClick(View v )
	{
		Intent intent=new Intent(this,DownLoadService.class);
		startService(intent);
	}

}
