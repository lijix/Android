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
		//���ļ��л�ȡ�û���������
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
		//��ȡ�ļ�ƫ�����ö���
		SharedPreferences spf=getSharedPreferences("info", MODE_PRIVATE);
		//��ȡ�༭��
		Editor et=spf.edit();
		
		String strUser=etUsername.getText().toString();
		String strPWD=etPWD.getText().toString();
		//���û���������ŵ��༭����
		et.putString("User", strUser);
		et.putString("PWD", strPWD);
		//�ύ����
		et.commit();
		Toast.makeText(this, "�ύ�ɹ�������", Toast.LENGTH_LONG).show();
	}

	
}
