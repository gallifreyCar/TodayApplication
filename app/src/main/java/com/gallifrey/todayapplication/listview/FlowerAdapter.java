package com.gallifrey.todayapplication.listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.gallifrey.todayapplication.R;

import java.nio.channels.ClosedByInterruptException;
import java.util.LinkedList;

public class FlowerAdapter extends BaseAdapter {
    private LinkedList<Flower> mDatalist;
    private Context mContext;
    private  int count=0;//添加一个计数器看看，优化后view的创建次数
    public FlowerAdapter(LinkedList<Flower> datalist, Context context){
        mDatalist=datalist;
        mContext=context;
    }

    @Override
    public int getCount() {
        return mDatalist.size();
    }

    @Override
    public Object getItem(int i) {
        return mDatalist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    /**
     *这是优化前的代码，可重用性低，view不断新建，组件也不断查找
     *
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(mContext).inflate(R.layout.listitem, viewGroup, false);
            ImageView item_iv=view.findViewById(R.id.item_iv);
            TextView item_name=view.findViewById(R.id.item_name);
            TextView item_content=view.findViewById(R.id.item_content);


            item_iv.setImageResource(mDatalist.get(i).getImageId());
            item_name.setText(mDatalist.get(i).getName());
            item_content.setText(mDatalist.get(i).getContent());
            return view;
        }

    **/
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        //优化,为空才构造view;那样只有创建第一页能显示的花的view，之后的直接重用好了
        //实际测试效果是创建了7个view
        if(view==null) {
            //动态构造
            view = LayoutInflater.from(mContext).inflate(R.layout.listitem, viewGroup, false);
            viewHolder=new ViewHolder();

            viewHolder.item_iv=view.findViewById(R.id.item_iv);
            viewHolder.item_name=view.findViewById(R.id.item_name);
            viewHolder.item_content=view.findViewById(R.id.item_content);
            viewHolder.item_check=view.findViewById(R.id.item_check);
            view.setTag(viewHolder);//用view记录数据，不用重复查找
            count++;//view的创建数+1
    }else {
            viewHolder=(ViewHolder)view.getTag();//重新赋值
        }
        Log.i("Flower", "getView: 测试一下优化效果 "+count);
        //记录一下位置
        viewHolder.item_check.setTag(i);
        viewHolder.item_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //重新获取位置并设置状态
                int index=(int)compoundButton.getTag();
                mDatalist.get(index).setCheckStatus(b);
            }
        });
        //重新设置
        viewHolder.item_check.setChecked(mDatalist.get(i).getCheckStatus());
        viewHolder.item_iv.setImageResource(mDatalist.get(i).getImageId());
        viewHolder.item_name.setText(mDatalist.get(i).getName());
        viewHolder.item_content.setText(mDatalist.get(i).getContent());
        return view;
    }

    //优化,添加一个静态类记录数据,增加重用性
    static class ViewHolder{
        ImageView item_iv;
        TextView item_name;
        TextView item_content;
        CheckBox item_check;

    }

    //添加点击删除功能
    public void remove(int position){
        if(mDatalist!=null){
            mDatalist.remove(position);
        }
        //更新变化的信息
        notifyDataSetChanged();

    }

}
