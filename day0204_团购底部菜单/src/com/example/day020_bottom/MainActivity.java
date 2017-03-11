package com.example.day020_bottom;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private RadioGroup rgMain;
	private RadioButton rbDeal,rbMore,rbMine,rbNearBy;
	private TextView tvShow;
	String text=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//初始化控件
		setupView();
		//加监听器
		addListener();
	
	}
	
	private void addListener() {
		// TODO Auto-generated method stub
		rgMain.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.rb_deal:
					text=rbDeal.getText().toString();
					break;
				case R.id.rb_mine:
					text=rbMine.getText().toString();
					break;
				case R.id.rb_more:
					text=rbMore.getText().toString();
					break;
				case R.id.rb_nearby:
					text=rbNearBy.getText().toString();
					break;
				default:
					break;
				}
				tvShow.setText(text);
			}
		});
		
	}
	private void setupView() {
		rgMain=(RadioGroup) findViewById(R.id.rg_main); 
		rbMine=(RadioButton) findViewById(R.id.rb_mine);
		rbMore=(RadioButton) findViewById(R.id.rb_more);
		rbNearBy=(RadioButton) findViewById(R.id.rb_nearby);
		rbDeal=(RadioButton) findViewById(R.id.rb_deal);
		tvShow=(TextView) findViewById(R.id.tv_show);
	}

	

}
