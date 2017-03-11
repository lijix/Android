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

	//声明控件
	private ViewPager vp;
	int[] imgs={R.drawable.png_1,R.drawable.png_2,R.drawable.png_3};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//初始化控件对象
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

		//判断该对象是否生成界面
		@Override
		public boolean isViewFromObject(View view, Object object) {
			
			return view==object;
		}
		//执行包饺子的动作
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			ImageView img=new ImageView(MainActivity.this);
			//设置图片在按页面上的大小
			img.setScaleType(ScaleType.FIT_XY);
			img.setImageResource(imgs[position]);
			
			//把翻页所需要的图片加到容器中
			container.addView(img);
			
			return img;
		}
		
		//销毁不需要的界面
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}

}
