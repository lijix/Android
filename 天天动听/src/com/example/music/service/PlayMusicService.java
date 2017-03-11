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
	 * service服务：主要用于后天之行的一些耗时操作
	 */

	private ArrayList<String> music;
	private BroadcastReceiver receiver;
	private MediaPlayer player = null;
	private File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);

	private int currentMusicIndex;
	// 某一首歌的暂停位置
	private int pausePosition;
	private boolean isRunning;
	//歌曲是否正在播放
	private boolean isStarted;

	@Override
	public void onCreate() {
		super.onCreate();
		player = new MediaPlayer();
		// 注册广播
		receiver = new myMusicReciver();
		IntentFilter filter = new IntentFilter();
		// 需要过滤的广播
		filter.addCategory(Intent.CATEGORY_DEFAULT);
		filter.addAction("PlaycurrentMusicIndex");
		filter.addAction("setPlayOrPause");
		filter.addAction("PlayMusicPrevious");
		filter.addAction("PlayMusicNext");
		filter.addAction("seekToPosition");
		registerReceiver(receiver, filter);

		// 当歌曲播放时，每隔一秒发一次广播告诉Activity更新进度
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

	// service服务的一个生命周期方法，主要执行service的主线程
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		music = intent.getStringArrayListExtra("music");

		return START_NOT_STICKY;
	}

	@Override
	public IBinder onBind(Intent intent) {

		return null;
	}

	// 播放音乐
	public void play() {
		try {

			player.reset();
			player.setDataSource(dir + "/" + music.get(currentMusicIndex));
			player.prepare();
			// 回到暂停位置播放
			player.seekTo(pausePosition);
			player.start();
			pausePosition = 0;

			// 一开始
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

	// 暂停音乐
	public void pause() {
		if (player.isPlaying()) {
			player.pause();
			// 当歌曲暂停后获取一个暂停位置
			pausePosition = player.getCurrentPosition();
			Intent intent = new Intent("setImgPlay");
			sendBroadcast(intent);
		}
	}

	public void previous() {
		// 当前歌曲位置减1
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

	// 接受Activity广播
	class myMusicReciver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// 渠道所有的广播
			String action = intent.getAction();
			if ("PlaycurrentMusicIndex".equals(action)) {
				// 开始播放某个位置音乐

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
				// 比方下首歌曲
				next();
			} else if ("seekToPosition".equals(action)) {
				// 获取当前seekBar所在的百分比
				int percent = intent.getIntExtra("seekPosition", 0);
				// 获取当前的暂停位置
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
