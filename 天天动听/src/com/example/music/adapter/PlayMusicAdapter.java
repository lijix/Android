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

	// 拿到饺子馅
	private List<String> musics;
	private Context context;

	// 构造方法用来传值,拿到Activity里面的饺子馅资源
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
//包饺子的动作
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
