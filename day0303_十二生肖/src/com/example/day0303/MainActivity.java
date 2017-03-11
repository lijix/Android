package com.example.day0303;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
		// TODO Auto-generated method stub
		lv=(ListView) findViewById(R.id.lv);
		MyAdapter adapter=new MyAdapter();
		lv.setAdapter(adapter);
		
	}
	//�����ӵ��ˣ������࣬��Ҫдһ����̳���
	class MyAdapter extends BaseAdapter{

		//��ȡ���ӵĸ���
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return imgs.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		//ִ�а����ӵĶ���
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View itemView=View.inflate(getApplicationContext(), R.layout.item_layout, null);
			
			ImageView img=(ImageView) itemView.findViewById(R.id.img);
			TextView tv=(TextView) itemView.findViewById(R.id.tv);
			
			img.setImageResource(imgs[position]);
			tv.setText(strs[position]);
			return itemView;
		}
		
	}

}
