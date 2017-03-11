package com.example.day0603_bandservice;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.example.day0603_bandservice.PlayMusicService.myBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	//Activity��Service��Ҫ����һ��������
	private ServiceConnection conn;
	//�󶨵���ͼ
	private Intent service;
	//�󶨵�ģʽ
	private int flags;
	
	private  myBinder binder=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("TAG", "Activity----onCreate");
		//��Service
		service=new Intent(this,PlayMusicService.class);
		conn=new ServiceConnection() {
			
			@Override
			public void onServiceDisconnected(ComponentName name) {
				
			}
			
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				binder=(myBinder) service;
			}
		};
		flags=BIND_AUTO_CREATE;
		bindService(service, conn, flags);
	}
	  public void onClick(View v)
	  {
		  switch (v.getId()) {
		case R.id.button1:
			//��������
			binder.Iplay();
			break;
		case R.id.button2:
			//��ͣ����
			binder.Ipause();
			break;

		default:
			break;
		}
	  }
	
@Override
protected void onDestroy() {
	super.onDestroy();
	Log.i("TAG", "Activity----onDestroy");
}
	

}
