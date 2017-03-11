package com.example.day0403_viewpager;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MainActivity extends Activity {

	//�����ؼ�
	private ViewPager vp;
	int[] imgs={R.drawable.png_1,R.drawable.png_2,R.drawable.png_3};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//��ʼ���ؼ�����
		vp=(ViewPager) findViewById(R.id.vp);
		myAdapter adapter=new myAdapter();
		vp.setAdapter(adapter);
	}

	class myAdapter extends PagerAdapter
	{

		@Override
		public int getCount() {
			
			return imgs.length;
		}

		//�жϸö����Ƿ����ɽ���
		@Override
		public boolean isViewFromObject(View view, Object object) {
			
			return view==object;
		}
		//ִ�а����ӵĶ���
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			ImageView img=new ImageView(MainActivity.this);
			//����ͼƬ�ڰ�ҳ���ϵĴ�С
			img.setScaleType(ScaleType.FIT_XY);
			img.setImageResource(imgs[position]);
			
			//�ѷ�ҳ����Ҫ��ͼƬ�ӵ�������
			container.addView(img);
			
			return img;
		}
		
		//���ٲ���Ҫ�Ľ���
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}

}
