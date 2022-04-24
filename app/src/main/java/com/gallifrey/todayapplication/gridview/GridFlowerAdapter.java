package com.gallifrey.todayapplication.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gallifrey.todayapplication.R;
import com.gallifrey.todayapplication.listview.Flower;

import java.util.List;

public class GridFlowerAdapter extends BaseAdapter {
    private List<Flower> mData;
    private Context mContext;

    public GridFlowerAdapter(List<Flower> data,Context context){
        mData=data;
        mContext=context;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if (view==null){
            view= LayoutInflater.from(mContext).inflate(R.layout.griditem,viewGroup,false);
            viewHolder=new ViewHolder();
            viewHolder.imageView=view.findViewById(R.id.gv_iv);
            viewHolder.textView=view.findViewById(R.id.gv_tv);
            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(mData.get(i).getImageId());
        viewHolder.textView.setText(mData.get(i).getName());
        return view;
    }

    static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
