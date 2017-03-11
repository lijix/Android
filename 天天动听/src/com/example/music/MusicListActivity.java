package com.example.music;

import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract.Contacts.Data;
import android.support.v4.widget.DrawerLayout;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.music.adapter.PlayMusicAdapter;
import com.example.music.service.PlayMusicService;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MusicListActivity extends Activity {

	private ListView lvDrawer;
	private DrawerLayout drawer;
	private ImageView imgDrawer;
	private int currentDuration;
	private SeekBar sb;
	private TextView tvCurrentTime;
	private TextView tvDurationTime;
	private TextView tvMusicName;
	private ImageButton ibNext;
	private ImageButton ibPlay;
	private ImageButton ibPrevious;
	private ListView lv;
	private File dir = null;
	// 准备一个集合。用来存放所有歌曲
	private ArrayList<String> music = null;

	private BroadcastReceiver receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music_list);

		setupView();
		addListener();
		// 注册广播
		receiver = new myserviceReceiver();
		IntentFilter filter = new IntentFilter();
		filter.addCategory(Intent.CATEGORY_DEFAULT);
		filter.addAction("setImgPause");
		filter.addAction("setImgPlay");
		filter.addAction("setMusicNameOrMusicDuration");
		filter.addAction("updatePrograss");
		filter.addAction("aaa");
		registerReceiver(receiver, filter);
	}

	private void addListener() {
		lvDrawer.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				drawer.closeDrawer(lvDrawer);
				
			}
		});
		
		imgDrawer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				drawer.openDrawer(lvDrawer);
			}
		});
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			//拖动到某个位置是开始执行操作
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				//获取停止位置的百分比
			int currentStopPosition=seekBar.getProgress();
			Intent intent=new Intent("seekToPosition");
			intent.putExtra("seekPosition", currentStopPosition);
			sendBroadcast(intent);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				
			}
		});
		ibNext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent("PlayMusicNext");
				sendBroadcast(intent);
			}
		});
		// 当点击上一首歌曲按钮时，发送一条广播
		ibPrevious.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent("PlayMusicPrevious");
				sendBroadcast(intent);
			}
		});

		// 当点击播放按钮，开始播放
		ibPlay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 发送一个广播，实现歌曲的暂停和播放
				Intent intent = new Intent("setPlayOrPause");
				sendBroadcast(intent);
			}
		});
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// 发送一个广播,告诉service点钟是哪一个歌曲
				Intent intent = new Intent("PlaycurrentMusicIndex");
				// 携带被点击的位置
				intent.putExtra("position", position);
				// 发送广播
				sendBroadcast(intent);

			}
		});
	}

	private void setupView() {
		lvDrawer=(ListView) findViewById(R.id.lv);
		final String[] strs={"登录","扫描歌曲","设置皮肤","设置","播放模式","退出"};
		ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,strs);
		lvDrawer.setAdapter(adapter1);
		
		
		drawer=(DrawerLayout) findViewById(R.id.drawerLayout);
		imgDrawer=(ImageView) findViewById(R.id.img_title_right);
		sb = (SeekBar) findViewById(R.id.sb);
		tvCurrentTime = (TextView) findViewById(R.id.tv_currenttime);
		tvDurationTime = (TextView) findViewById(R.id.tv_durattime);
		tvMusicName = (TextView) findViewById(R.id.tv_list_musicname);
		lv = (ListView) findViewById(R.id.lv_musiclist);
		// 获取歌曲缓存的路径
		dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);

		// 获取所有的歌曲,饺子馅
		File[] files = dir.listFiles();
		music = new ArrayList<String>();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				music.add(files[i].getName());
			}
		}

		PlayMusicAdapter adapter = new PlayMusicAdapter(music, this);
		lv.setAdapter(adapter);

		//
		Intent intent = new Intent(this, PlayMusicService.class);
		// 把所有的音乐文件传递到服务
		intent.putStringArrayListExtra("music", music);
		startService(intent);

		ibPlay = (ImageButton) findViewById(R.id.img_list_play);
		ibPrevious = (ImageButton) findViewById(R.id.img_list_previous);
		ibNext = (ImageButton) findViewById(R.id.img_list_next);

	}

	class myserviceReceiver extends BroadcastReceiver {



		@Override
		public void onReceive(Context context, Intent intent) {
			// 获取所有的广播
			String action = intent.getAction();
			if ("setImgPause".equals(action)) {
				// 暂停

				ibPlay.setImageResource(android.R.drawable.ic_media_pause);
			} else if ("setImgPlay".equals(action)) {
				ibPlay.setImageResource(android.R.drawable.ic_media_play);
			} else if ("setMusicNameOrMusicDuration".equals(action)) {
				// 获取当前歌曲名称
				String musicName = intent.getStringExtra("MusicName");
				tvMusicName.setText("正在播放：" + musicName);

				// 获取总时长
				 currentDuration = intent.getIntExtra("MusicDuration", 1);
				// 通过工具类，将总时长转化为想要的格式
				SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
				// 把获取的毫秒值转化为date对象
				Date dateDuration = new Date();
				dateDuration.setTime(currentDuration);
				// 把获取到的只放到相应控件上
				tvDurationTime.setText(sdf.format(dateDuration));

			} else if ("updatePrograss".equals(action)) {
				int currentPosition = intent.getIntExtra("currentPosition", 0);
				SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
				Date dateCurrent = new Date();
				dateCurrent.setTime(currentPosition);
				tvCurrentTime.setText(sdf.format(dateCurrent));
				if (currentDuration != 0) {
					int percent = currentPosition*100/currentDuration;
					sb.setProgress(percent);
				}
			}else if("aaa".equals(action))
			{
				int pause=intent.getIntExtra("aaPosition", 0);
				SimpleDateFormat sdf=new SimpleDateFormat("mm:ss");
				Date dd=new Date(pause);
				tvCurrentTime.setText(sdf.format(dd));
				
			}
		}

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregisterReceiver(receiver);
	}

}
