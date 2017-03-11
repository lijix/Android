package com.example.day00302_listview;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	//�����ؼ�
	private ListView lv;
	@SuppressWarnings("rawtypes")
	//����
	List list=new ArrayList();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//��ʼ���ؼ�����
		setupView();
	}
	@SuppressWarnings("unchecked")
	private void setupView() {
		// TODO Auto-generated method stub
		lv=(ListView) findViewById(R.id.lv);
		for(int i=0;i<30;i++){
			list.add(i);
		}
		//�ҵ������ӵ���
		@SuppressWarnings("rawtypes")
		ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
		//�ѽ����¹�
		lv.setAdapter(adapter);
	}


}
