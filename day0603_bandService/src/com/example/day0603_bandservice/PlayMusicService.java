package com.example.day0603_bandservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class PlayMusicService extends Service{

	/**
	 * ��ģʽ��Service����Ҫ������Activity֮�䳤ʱ��Ľ���
	 */
	@Override
	public IBinder onBind(Intent intent) {
		
		return new myBinder();
	}
	
	public void play()
	{
		Log.i("TAG", "��������");
	}
	public void pause()
	{
		Log.i("TAG", "��ͣ����");
	}
	//��ʹ��
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
