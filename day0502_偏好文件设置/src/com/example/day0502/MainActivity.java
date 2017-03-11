package com.example.day0502;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText etUsername,etPWD;
	private CheckBox cb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setupView();
		readContent();
	}

	private void readContent() {
		SharedPreferences spf=getSharedPreferences("info", MODE_PRIVATE);
		//从文件中获取用户名和密码
		String user=spf.getString("User", "");
		String pwd=spf.getString("PWD", "");
		
		etPWD.setText(pwd);
		etUsername.setText(user);
		
	}

	private void setupView() {
		etPWD=(EditText) findViewById(R.id.editText2);
		etUsername=(EditText) findViewById(R.id.editText1);
		cb=(CheckBox) findViewById(R.id.checkBox1);
		
	}
	
	public void onClick(View v)
	{
		//获取文件偏好设置对象
		SharedPreferences spf=getSharedPreferences("info", MODE_PRIVATE);
		//获取编辑器
		Editor et=spf.edit();
		
		String strUser=etUsername.getText().toString();
		String strPWD=etPWD.getText().toString();
		//把用户名和密码放到编辑器里
		et.putString("User", strUser);
		et.putString("PWD", strPWD);
		//提交事务
		et.commit();
		Toast.makeText(this, "提交成功！！！", Toast.LENGTH_LONG).show();
	}

	
}
