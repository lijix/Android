package com.example.day0603_bandservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class PlayMusicService extends Service{

	/**
	 * 绑定模式的Service，主要用于与Activity之间长时间的交互
	 */
	@Override
	public IBinder onBind(Intent intent) {
		
		return new myBinder();
	}
	
	public void play()
	{
		Log.i("TAG", "播放音乐");
	}
	public void pause()
	{
		Log.i("TAG", "暂停音乐");
	}
	//信使，
	class myBinder extends Binder{
		public void Iplay()
		{
			play();
		}
		public void Ipause(){
			pause();
		}
	}
}
