package com.example.day0108_pay;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	//声明控件
	private Button btnZFB;
	private Button btnWX;
	private Button btnXYK;
	private Button btnHDFK;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件对象
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
			  //Toast.makeText(this, "您选择了支付宝支付，正在为您。。。。", Toast.LENGTH_LONG).show();
			  text=btnZFB.getText().toString();
			break;
		case R.id.bt_wx:
			text=btnWX.getText().toString();
			  //Toast.makeText(this, "您选择了微信支付，正在为您。。。。", Toast.LENGTH_LONG).show();
			break;
		case R.id.bt_xyk:
			text=btnXYK.getText().toString();
			 // Toast.makeText(this, "您选择了信用卡支付，正在为您。。。。", Toast.LENGTH_LONG).show();
			break;
		case R.id.bt_hdfk:
			text=btnHDFK.getText().toString();
			//  Toast.makeText(this, "您选择了货到付款，正在为您。。。。", Toast.LENGTH_LONG).show();
			break;
		default:
			break;
		}
    	Toast.makeText(this, "您选择了"+text+"的支付方式，正在为您跳转页面，请勿退出操作。。。。。", Toast.LENGTH_LONG).show();
    }


    
}
