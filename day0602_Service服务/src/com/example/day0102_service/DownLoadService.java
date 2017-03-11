package com.example.day0102_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Service����ִ��һ�����ز���
 * 
 * @author Administrator
 *
 */
public class DownLoadService extends Service {

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i("TAG", "Service-----onCreate");
	}
	@Override
	public int onStartCommand(Intent intent, int flags, final int startId) {
		new Thread(new Runnable() {
			
			
			//run�������߳�ר��ִ�к�ʱ����
			@Override
			public void run() {
				//ģ������
				for(int i=0;i<=10;i++)
				{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Log.i("Tag", "������"+10*i+"%");
				}
				Log.i("TAG", "��ϲ�㣡���������");
				stopSelf(startId);
			}
		}).start();
		return START_NOT_STICKY;
		//return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i("TAG", "Service-----onDestory");
	}
}
