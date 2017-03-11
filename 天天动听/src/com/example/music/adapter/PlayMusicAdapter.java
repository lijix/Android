package com.example.music.adapter;

import java.util.List;

import com.example.music.R;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PlayMusicAdapter extends BaseAdapter {

	// �õ�������
	private List<String> musics;
	private Context context;

	// ���췽��������ֵ,�õ�Activity����Ľ�������Դ
	public PlayMusicAdapter(List<String> musics, Context context) {

		this.musics = musics;
		this.context = context;
	}

	@Override
	public int getCount() {
		return musics.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}
//�����ӵĶ���
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if(convertView==null)
		{
			convertView=LayoutInflater.from(context).inflate(R.layout.item_layout, null);
					holder=new ViewHolder();
			holder.tvMusicName=(TextView) convertView.findViewById(R.id.tv_musicname_layout);
			convertView.setTag(holder);
			
		}else
		{
			holder=(ViewHolder) convertView.getTag();
		}
		holder.tvMusicName.setText(musics.get(position));
		return convertView;
	}
   class ViewHolder{
	   private TextView tvMusicName;
	   
   }
   
   

}
