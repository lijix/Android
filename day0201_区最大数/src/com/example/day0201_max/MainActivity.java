package com.example.day0201_max;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	//声明控件对象
	
	private EditText eta,etb,etc;
	private Button btMax;
	private TextView tvResult;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//初始化控件对象
		eta=(EditText) findViewById(R.id.editText1);
		etb=(EditText) findViewById(R.id.editText2);
		etc=(EditText) findViewById(R.id.editText3);
		btMax=(Button) findViewById(R.id.bt_max);
		tvResult=(TextView) findViewById(R.id.tv_result);
		
	}
	//事件以及所有的事件逻辑
	public void setResult(View v){
		String stra=eta.getText().toString();
		String strb=etb.getText().toString();
		String strc=etc.getText().toString();
		
		 int a=Integer.parseInt(stra);
		 int b=Integer.parseInt(strb);
		 int c=Integer.parseInt(strc); 
		 //运用三目运算符进行大小比较
		 int max=a>b ?a : b;
		 int resultMax=max>c ? max :  c;
		 //把比较后的最大值设置到要显示的TextView上
		 
		 tvResult.setText("最大值是："+resultMax);
		 
	}
}
