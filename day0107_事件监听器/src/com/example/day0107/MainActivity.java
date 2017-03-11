package com.example.day0107;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //事件源：是个Button
    //事件：onClick点击事件
    //处理逻辑
    public void onClick(View v)
    {
     	Toast.makeText(
     			//弹出框要显示的位置
     			this, 
     			//弹出文本的内容
     			"不要点我！", 
     			//弹出文本显示的时长
     			Toast.LENGTH_LONG).show();
    }
}
