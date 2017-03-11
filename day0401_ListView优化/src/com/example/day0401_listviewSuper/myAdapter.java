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
 * �����ӵ���
 * @author Administrator
 *
 */
public class myAdapter extends BaseAdapter{

	private int[]  imgs;
	private String[] strs;
	
	private Context context;

	/**
	 * ͨ�����췽���������ڴ���
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
		/*//ͨ����ͼ��������ȡ����Ƥ
		LayoutInflater inflater=LayoutInflater.from(context);
		//��ȡ����Ƥ
		View itemView=inflater.inflate(R.layout.item_layout,null);
		//��ȡ����Ƥ�Ŀؼ�����
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
			//��ȡ����Ƥ
			convertView=LayoutInflater.from(context).inflate(R.layout.item_layout, null);
			holder=new ViewHolder();
			//��ȡ����Ƥ�ϵĿؼ�
			holder.img=(ImageView) convertView.findViewById(R.id.img);
			holder.tv=(TextView) convertView.findViewById(R.id.tv);
			//������Ƥ�ӱ�ǩ
			convertView.setTag(holder);
			
		}else
		{   //�����convertViewֱ�Ӹ�������ʹ��
			holder=(ViewHolder) convertView.getTag();
		}
		//���ؼ���������Դ
		holder.img.setImageResource(imgs[position]);
		holder.tv.setText(strs[position]);
		return convertView;
		
	}
	//���������+
	class ViewHolder
	{
		private ImageView img;
		private TextView tv;
	}
	
}
