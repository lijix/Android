package com.example.day0108_pay;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	//�����ؼ�
	private Button btnZFB;
	private Button btnWX;
	private Button btnXYK;
	private Button btnHDFK;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //��ʼ���ؼ�����
        btnZFB=(Button)findViewById(R.id.bt_zfb);
        btnWX=(Button)findViewById(R.id.bt_wx);
        btnXYK=(Button)findViewById(R.id.bt_xyk);
        btnHDFK=(Button)findViewById(R.id.bt_hdfk);
    }
    public void payment(View v)
    { 
    	String text=null;
    	switch (v.getId()) {
		case R.id.bt_zfb:
			  //Toast.makeText(this, "��ѡ����֧����֧��������Ϊ����������", Toast.LENGTH_LONG).show();
			  text=btnZFB.getText().toString();
			break;
		case R.id.bt_wx:
			text=btnWX.getText().toString();
			  //Toast.makeText(this, "��ѡ����΢��֧��������Ϊ����������", Toast.LENGTH_LONG).show();
			break;
		case R.id.bt_xyk:
			text=btnXYK.getText().toString();
			 // Toast.makeText(this, "��ѡ�������ÿ�֧��������Ϊ����������", Toast.LENGTH_LONG).show();
			break;
		case R.id.bt_hdfk:
			text=btnHDFK.getText().toString();
			//  Toast.makeText(this, "��ѡ���˻����������Ϊ����������", Toast.LENGTH_LONG).show();
			break;
		default:
			break;
		}
    	Toast.makeText(this, "��ѡ����"+text+"��֧����ʽ������Ϊ����תҳ�棬�����˳���������������", Toast.LENGTH_LONG).show();
    }


    
}
