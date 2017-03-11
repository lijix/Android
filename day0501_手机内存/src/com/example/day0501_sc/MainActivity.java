package com.example.day0501_sc;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	//�����ؼ�����
	private EditText etUsername,etPassword;
	private CheckBox cb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//��ʼ���ؼ�
		setupView();
		readContent();
	}

	private void setupView() {
		etPassword=(EditText) findViewById(R.id.editText2);
		etUsername=(EditText) findViewById(R.id.editText1);
		cb=(CheckBox) findViewById(R.id.checkBox1);
	}
	public void readContent()
	{
		File file=new File("data/data/com.example.day0501_sc/info.txt");
		FileInputStream fis=null;
		BufferedReader br=null;
		try {
			//�����ַ���������ȡ�ļ�
			fis=new FileInputStream(file);
			br=new BufferedReader(new InputStreamReader(fis));
			String text=br.readLine();
			//һ��һ�еĶ�ȡ
			String[] strs=text.split("##");
			//���û���������ŵ���Ӧ�Ŀؼ�����ʾ
			etUsername.setText(strs[0]);
			etPassword.setText(strs[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}if(fis!=null)
		{
			
		}
	}

	public void onClick(View v) {
		if(cb.isChecked()){
		//����������ı�����
		String strUser=etUsername.getText().toString();
		String strPWD=etPassword.getText().toString();
		//�ѻ�ȡ���ı�д�뵽����
		File file=new File("data/data/com.example.day0501_sc/info.txt");
		//������������ļ�����д����
		FileOutputStream fos=null;
		
		try {
			fos=new FileOutputStream(file);
			fos.write((strUser+"##"+strPWD).getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fos!=null)
			{
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		Toast.makeText(this, "����ɹ���", Toast.LENGTH_LONG).show();
	}

}
}
