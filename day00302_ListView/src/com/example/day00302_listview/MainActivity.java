package com.example.day00302_listview;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	//声明控件
	private ListView lv;
	@SuppressWarnings("rawtypes")
	//集合
	List list=new ArrayList();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//初始化控件对象
		setupView();
	}
	@SuppressWarnings("unchecked")
	private void setupView() {
		// TODO Auto-generated method stub
		lv=(ListView) findViewById(R.id.lv);
		for(int i=0;i<30;i++){
			list.add(i);
		}
		//找到包饺子的人
		@SuppressWarnings("rawtypes")
		ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
		//把饺子下锅
		lv.setAdapter(adapter);
	}


}
