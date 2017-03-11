package com.example.day_0503_music;

import android.os.Bundle;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	private MediaPlayer play=null;

	//获取sd卡的数据
	private File dir=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC); 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupView();
	}
	private void setupView() {
		play=new MediaPlayer();
	}
public void onClick(View v) throws IllegalStateException, IOException 
{
   play.reset();
  
	play.setDataSource(dir+"/dream.mp3");
	play.prepare();
	play.start();
}
@Override
protected void onDestroy() {
	super.onDestroy();
	if(play!=null)
	{
		play.release();
		play.stop();
		play=null;
	}
}
}

	

