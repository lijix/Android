package com.example.day0201_max;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	//�����ؼ�����
	
	private EditText eta,etb,etc;
	private Button btMax;
	private TextView tvResult;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//��ʼ���ؼ�����
		eta=(EditText) findViewById(R.id.editText1);
		etb=(EditText) findViewById(R.id.editText2);
		etc=(EditText) findViewById(R.id.editText3);
		btMax=(Button) findViewById(R.id.bt_max);
		tvResult=(TextView) findViewById(R.id.tv_result);
		
	}
	//�¼��Լ����е��¼��߼�
	public void setResult(View v){
		String stra=eta.getText().toString();
		String strb=etb.getText().toString();
		String strc=etc.getText().toString();
		
		 int a=Integer.parseInt(stra);
		 int b=Integer.parseInt(strb);
		 int c=Integer.parseInt(strc); 
		 //������Ŀ��������д�С�Ƚ�
		 int max=a>b ?a : b;
		 int resultMax=max>c ? max :  c;
		 //�ѱȽϺ�����ֵ���õ�Ҫ��ʾ��TextView��
		 
		 tvResult.setText("���ֵ�ǣ�"+resultMax);
		 
	}
}
