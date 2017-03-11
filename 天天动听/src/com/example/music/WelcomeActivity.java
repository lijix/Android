package com.example.music;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WelcomeActivity extends Activity {

	private ImageView img1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		setupView();
	}

	private void setupView() {
		// TODO Auto-generated method stub
		img1=(ImageView) findViewById(R.id.img_welcome1);
		//���ض���
		Animation anim=AnimationUtils.loadAnimation(this, R.anim.alpha);
		//����������ͼƬ��
		img1.setAnimation(anim);
		anim.setAnimationListener(new AnimationListener() {
			
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				//����������ʱ����ת����ҳ��
				Intent intent=new Intent(WelcomeActivity.this, MainActivity.class);
				startActivity(intent);
				
			}
		});
		
	}

	

}
