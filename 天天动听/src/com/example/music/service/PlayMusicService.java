package com.example.music.service;

import java.io.File;
import java.util.ArrayList;

import android.R.integer;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Environment;
import android.os.IBinder;

public class PlayMusicService extends Service {

	/**
	 * service������Ҫ���ں���֮�е�һЩ��ʱ����
	 */

	private ArrayList<String> music;
	private BroadcastReceiver receiver;
	private MediaPlayer player = null;
	private File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);

	private int currentMusicIndex;
	// ĳһ�׸����ͣλ��
	private int pausePosition;
	private boolean isRunning;
	//�����Ƿ����ڲ���
	private boolean isStarted;

	@Override
	public void onCreate() {
		super.onCreate();
		player = new MediaPlayer();
		// ע��㲥
		receiver = new myMusicReciver();
		IntentFilter filter = new IntentFilter();
		// ��Ҫ���˵Ĺ㲥
		filter.addCategory(Intent.CATEGORY_DEFAULT);
		filter.addAction("PlaycurrentMusicIndex");
		filter.addAction("setPlayOrPause");
		filter.addAction("PlayMusicPrevious");
		filter.addAction("PlayMusicNext");
		filter.addAction("seekToPosition");
		registerReceiver(receiver, filter);

		// ����������ʱ��ÿ��һ�뷢һ�ι㲥����Activity���½���
		isRunning = true;
		new UpdatePrograssThread().start();
		
		player.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				if(isStarted){
					next();
				}
			}
		});
	}

	// service�����һ���������ڷ�������Ҫִ��service�����߳�
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		music = intent.getStringArrayListExtra("music");

		return START_NOT_STICKY;
	}

	@Override
	public IBinder onBind(Intent intent) {

		return null;
	}

	// ��������
	public void play() {
		try {

			player.reset();
			player.setDataSource(dir + "/" + music.get(currentMusicIndex));
			player.prepare();
			// �ص���ͣλ�ò���
			player.seekTo(pausePosition);
			player.start();
			pausePosition = 0;

			// һ��ʼ
			Intent intent = new Intent("setImgPause");
			sendBroadcast(intent);

			Intent intent1 = new Intent("setMusicNameOrMusicDuration");
			intent1.putExtra("MusicName", music.get(currentMusicIndex)).toString();
			intent1.putExtra("MusicDuration", player.getDuration());
			sendBroadcast(intent1);
			
			
			isStarted=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ��ͣ����
	public void pause() {
		if (player.isPlaying()) {
			player.pause();
			// ��������ͣ���ȡһ����ͣλ��
			pausePosition = player.getCurrentPosition();
			Intent intent = new Intent("setImgPlay");
			sendBroadcast(intent);
		}
	}

	public void previous() {
		// ��ǰ����λ�ü�1
		currentMusicIndex--;
		if (currentMusicIndex < 0) {
			currentMusicIndex = music.size() - 1;
		}
		pausePosition = 0;
		play();
	}

	public void next() {
		currentMusicIndex++;
		if (currentMusicIndex > music.size() - 1) {
			currentMusicIndex = 0;
		}
		pausePosition = 0;
		play();
	}

	// ����Activity�㲥
	class myMusicReciver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// �������еĹ㲥
			String action = intent.getAction();
			if ("PlaycurrentMusicIndex".equals(action)) {
				// ��ʼ����ĳ��λ������

				currentMusicIndex = intent.getIntExtra("position", 1);

				pausePosition = 0;
				play();
			} else if ("setPlayOrPause".equals(action)) {
				if (player.isPlaying()) {
					pause();
				} else {
					play();
				}
			} else if ("PlayMusicPrevious".equals(action)) {
				previous();
			} else if ("PlayMusicNext".equals(action)) {
				// �ȷ����׸���
				next();
			} else if ("seekToPosition".equals(action)) {
				// ��ȡ��ǰseekBar���ڵİٷֱ�
				int percent = intent.getIntExtra("seekPosition", 0);
				// ��ȡ��ǰ����ͣλ��
				pausePosition = player.getDuration() * percent / 100;
				Intent intent1=new Intent("aaa");
				intent1.putExtra("aaPosition", pausePosition);
				sendBroadcast(intent1);
				if (player.isPlaying()) {
					play();
				} else {
					pause();
				}
			}
		}
	}

	class UpdatePrograssThread extends Thread {
		@Override
		public void run() {
			super.run();
			Intent intent = new Intent("updatePrograss");

			while (isRunning) {
				if (player.isPlaying()) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					intent.putExtra("currentPosition", player.getCurrentPosition());
					sendBroadcast(intent);
				}
			}
		}
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregisterReceiver(receiver);
	}
}
