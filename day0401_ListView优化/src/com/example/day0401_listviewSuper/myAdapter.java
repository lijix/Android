package com.example.day0401_listviewSuper;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * 包饺子的人
 * @author Administrator
 *
 */
public class myAdapter extends BaseAdapter{

	private int[]  imgs;
	private String[] strs;
	
	private Context context;

	/**
	 * 通过构造方法将饺子馅传递
	 */
	public myAdapter(int[] imgs,String[] strs,Context context)
	{
		this.context=context;
		this.imgs=imgs;
		this.strs=strs;
	}
	@Override
	public int getCount() {
		return imgs.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		/*//通过视图扩充器获取饺子皮
		LayoutInflater inflater=LayoutInflater.from(context);
		//获取饺子皮
		View itemView=inflater.inflate(R.layout.item_layout,null);
		//获取饺子皮的控件对象
		ImageView img=(ImageView) itemView.findViewById(R.id.img);
		TextView tv=(TextView) itemView.findViewById(R.id.tv);
		
		img.setImageResource(imgs[position]);
		tv.setText(strs[position]);
		return itemView;*/
		/*if(convertView==null)
		{
			convertView=LayoutInflater.from(context).inflate(R.layout.item_layout, null);
			
		}
		ImageView img=(ImageView) convertView.findViewById(R.id.img);
		TextView tv=(TextView) convertView.findViewById(R.id.tv);
		img.setImageResource(imgs[position]);
		tv.setText(strs[position]);
		return convertView;*/
		ViewHolder holder=null;
		if(convertView==null)
		{   
			//获取饺子皮
			convertView=LayoutInflater.from(context).inflate(R.layout.item_layout, null);
			holder=new ViewHolder();
			//获取饺子皮上的控件
			holder.img=(ImageView) convertView.findViewById(R.id.img);
			holder.tv=(TextView) convertView.findViewById(R.id.tv);
			//给饺子皮加标签
			convertView.setTag(holder);
			
		}else
		{   //如果有convertView直接根据拿来使用
			holder=(ViewHolder) convertView.getTag();
		}
		//给控件设置数据源
		holder.img.setImageResource(imgs[position]);
		holder.tv.setText(strs[position]);
		return convertView;
		
	}
	//对象持有者+
	class ViewHolder
	{
		private ImageView img;
		private TextView tv;
	}
	
}
