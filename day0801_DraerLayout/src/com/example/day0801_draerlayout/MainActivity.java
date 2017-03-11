package com.example.day0801_draerlayout;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ListView lv;
	private TextView tv;
	private DrawerLayout drawer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupView();
	}
	private void setupView() {
		tv=(TextView) findViewById(R.id.tv);
		lv=(ListView) findViewById(R.id.lv);
		final String[] strs={"登录","设置皮肤","设置","播放模式","退出"};
		ArrayAdapter< String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,strs);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				tv.setText(strs[position].toString());
				drawer.closeDrawer(lv);
			}
		});
	}


}
