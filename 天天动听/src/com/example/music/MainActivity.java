package com.example.music;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.example.music.fragment.MyMusicFragment;
import com.example.music.fragment.RecommentFragment;
import com.example.music.fragment.SearchFragment;
import com.example.music.fragment.TaoGeFragment;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Switch;

public class MainActivity extends FragmentActivity {

	private ViewPager vp;
	private RadioGroup rgMain;
	private RadioButton rbMine, rbTaoGe, rbSearch, rbReconmment;
	private ImageButton imgList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ��ʼ��
		setupView();
		// ���һ�������������������йؼ������Ĳ������Ž������У�
		addListener();
	}

	private void addListener() {

		imgList.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, MusicListActivity.class);
				startActivity(intent);
			}
		});

		// ��ViewPager��һ��������
		vp.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				switch (position) {
				case 0:
					rgMain.check(R.id.rb_mine);
					break;
				case 1:
					rgMain.check(R.id.rb_taoge);
					break;
				case 2:
					rgMain.check(R.id.rb_search);
					break;
				case 3:
					rgMain.check(R.id.rb_recomment);
					break;

				default:
					break;
				}
			}

			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});

		// ��RadoiaGroupe���һ��������
		rgMain.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				// ���ҵ���ҵĸ���ʱ���л����ҵĸ���ҳ��
				case R.id.rb_mine:
					vp.setCurrentItem(0);
					break;
				case R.id.rb_recomment:
					vp.setCurrentItem(3);
					break;
				case R.id.rb_taoge:
					vp.setCurrentItem(1);
					break;
				case R.id.rb_search:
					vp.setCurrentItem(2);
					break;

				default:
					break;
				}
			}
		});
	}

	private void setupView() {

		vp = (ViewPager) findViewById(R.id.vp);

		imgList = (ImageButton) findViewById(R.id.img_bottom_list);

		myPagerAdapter adapter = new myPagerAdapter(getSupportFragmentManager());
		vp.setAdapter(adapter);

		rgMain = (RadioGroup) findViewById(R.id.rg_main);
		rbReconmment = (RadioButton) findViewById(R.id.rb_recomment);
		rbSearch = (RadioButton) findViewById(R.id.rb_search);
		rbTaoGe = (RadioButton) findViewById(R.id.rb_taoge);
		rbMine = (RadioButton) findViewById(R.id.rb_mine);

	}

	// ����ʢ��fragment��������
	class myPagerAdapter extends FragmentPagerAdapter {

		public myPagerAdapter(FragmentManager fm) {

			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// ����Fragment
			Fragment fm = null;
			switch (position) {
			case 0:
				fm = new MyMusicFragment();
				break;
			case 1:
				fm = new TaoGeFragment();
				break;
			case 2:
				fm = new SearchFragment();
				break;
			case 3:
				fm = new RecommentFragment();
				break;
			default:
				break;
			}
			return fm;
		}

		@Override
		public int getCount() {

			return 4;
		}

	}
}
