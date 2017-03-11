package com.example.day0402_activitylife;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("TAG","Activity----->onCreate()");
		btn=(Button) findViewById(R.id.bt);
		
	}
	public void onClick(View v)
	{
		Intent intent=new Intent(this, SecondActivity.class);
		startActivity(intent);
	}
	@Override
	protected void onStart() {
		super.onStart();
		Log.i("TAG","Activity----->onStart()");
	}
	@Override
	protected void onResume() {
		super.onResume();
		Log.i("TAG","Activity----->onResume()");
	}
	@Override
	protected void onPause() {
		super.onPause();
		Log.i("TAG","Activity----->onPause()");
	}
	@Override
	protected void onStop() {
		super.onStop();
		Log.i("TAG","Activity----->onStap()");
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("TAG","Activity----->onDestroy()");
	}
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i("TAG","Activity----->onRestart()");
	}

}
