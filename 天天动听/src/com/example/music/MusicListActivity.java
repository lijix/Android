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
	// ׼��һ�����ϡ�����������и���
	private ArrayList<String> music = null;

	private BroadcastReceiver receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music_list);

		setupView();
		addListener();
		// ע��㲥
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
			//�϶���ĳ��λ���ǿ�ʼִ�в���
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				//��ȡֹͣλ�õİٷֱ�
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
		// �������һ�׸�����ťʱ������һ���㲥
		ibPrevious.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent("PlayMusicPrevious");
				sendBroadcast(intent);
			}
		});

		// ��������Ű�ť����ʼ����
		ibPlay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// ����һ���㲥��ʵ�ָ�������ͣ�Ͳ���
				Intent intent = new Intent("setPlayOrPause");
				sendBroadcast(intent);
			}
		});
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// ����һ���㲥,����service��������һ������
				Intent intent = new Intent("PlaycurrentMusicIndex");
				// Я���������λ��
				intent.putExtra("position", position);
				// ���͹㲥
				sendBroadcast(intent);

			}
		});
	}

	private void setupView() {
		lvDrawer=(ListView) findViewById(R.id.lv);
		final String[] strs={"��¼","ɨ�����","����Ƥ��","����","����ģʽ","�˳�"};
		ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,strs);
		lvDrawer.setAdapter(adapter1);
		
		
		drawer=(DrawerLayout) findViewById(R.id.drawerLayout);
		imgDrawer=(ImageView) findViewById(R.id.img_title_right);
		sb = (SeekBar) findViewById(R.id.sb);
		tvCurrentTime = (TextView) findViewById(R.id.tv_currenttime);
		tvDurationTime = (TextView) findViewById(R.id.tv_durattime);
		tvMusicName = (TextView) findViewById(R.id.tv_list_musicname);
		lv = (ListView) findViewById(R.id.lv_musiclist);
		// ��ȡ���������·��
		dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);

		// ��ȡ���еĸ���,������
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
		// �����е������ļ����ݵ�����
		intent.putStringArrayListExtra("music", music);
		startService(intent);

		ibPlay = (ImageButton) findViewById(R.id.img_list_play);
		ibPrevious = (ImageButton) findViewById(R.id.img_list_previous);
		ibNext = (ImageButton) findViewById(R.id.img_list_next);

	}

	class myserviceReceiver extends BroadcastReceiver {



		@Override
		public void onReceive(Context context, Intent intent) {
			// ��ȡ���еĹ㲥
			String action = intent.getAction();
			if ("setImgPause".equals(action)) {
				// ��ͣ

				ibPlay.setImageResource(android.R.drawable.ic_media_pause);
			} else if ("setImgPlay".equals(action)) {
				ibPlay.setImageResource(android.R.drawable.ic_media_play);
			} else if ("setMusicNameOrMusicDuration".equals(action)) {
				// ��ȡ��ǰ��������
				String musicName = intent.getStringExtra("MusicName");
				tvMusicName.setText("���ڲ��ţ�" + musicName);

				// ��ȡ��ʱ��
				 currentDuration = intent.getIntExtra("MusicDuration", 1);
				// ͨ�������࣬����ʱ��ת��Ϊ��Ҫ�ĸ�ʽ
				SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
				// �ѻ�ȡ�ĺ���ֵת��Ϊdate����
				Date dateDuration = new Date();
				dateDuration.setTime(currentDuration);
				// �ѻ�ȡ����ֻ�ŵ���Ӧ�ؼ���
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
