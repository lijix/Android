package com.example.day0401_listviewSuper;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lv;
	//׼������Դ
	int[] imgs={
			R.drawable.png_1,
			R.drawable.png_2,
			R.drawable.png_3,
			R.drawable.png_4,
			R.drawable.png_5,
			R.drawable.png_6,
			R.drawable.png_7,
			R.drawable.png_8,
			R.drawable.png_9,
			R.drawable.png_10,
			R.drawable.png_11,
			R.drawable.png_12,
			
	};
	String[] strs={"��",
			"ţ",
			"��",
			"��",
			"��",
			"��",
			"��",
			"��",
			"��",
			"��",
			"��",
			"��",};
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupView();
	}
	private void setupView() {
		lv=(ListView) findViewById(R.id.lv);
		//������������������
		myAdapter adapter=new myAdapter(imgs, strs, this);
		//�����¹�
		lv.setAdapter(adapter);
	}

	

}
