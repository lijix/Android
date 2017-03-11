package com.example.day0301_animation;

import android.os.Bundle;

import com.example.day0301_animation.R.anim;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView img;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupView();
	}

	private void setupView() {
		// TODO Auto-generated method stub
		img=(ImageView) findViewById(R.id.imageView1);
	}
	public void onClick(View v){
		switch (v.getId()) {
		case R.id.btn_alpha:
			Animation animation=AnimationUtils.loadAnimation(this, R.anim.alpha);
			img.setAnimation(animation);
			break;
		case R.id.btn_rotate:
			Animation animation1=AnimationUtils.loadAnimation(this, R.anim.rotate);
			img.setAnimation(animation1);
			break;
		case R.id.btn_scale:
			Animation animation2=AnimationUtils.loadAnimation(this, R.anim.scale);
			img.setAnimation(animation2);
			break;
		case R.id.btn_traslate:
			Animation animation3=AnimationUtils.loadAnimation(this, R.anim.translate);
			animation3.setFillAfter(true);
			animation3.setFillBefore(false);
			img.setAnimation(animation3);
			break;
		default:
			break;
		}
	}


}
