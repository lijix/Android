package com.example.day0202_yemiantiaozhuan;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClick(View v){
		//创建一个意图对象
		Intent intent=new Intent(this, SecondActivity.class);
		//启动意图
		startActivity(intent);
	}

}
