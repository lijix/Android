package com.example.day0202_yemiantiaozhuan;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	}
   public void onClick(View v){
	   Intent intent=new Intent(this,MainActivity.class);
	   startActivity(intent);
   }
}
