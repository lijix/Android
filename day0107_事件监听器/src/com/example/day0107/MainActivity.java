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
    //�¼�Դ���Ǹ�Button
    //�¼���onClick����¼�
    //�����߼�
    public void onClick(View v)
    {
     	Toast.makeText(
     			//������Ҫ��ʾ��λ��
     			this, 
     			//�����ı�������
     			"��Ҫ���ң�", 
     			//�����ı���ʾ��ʱ��
     			Toast.LENGTH_LONG).show();
    }
}
