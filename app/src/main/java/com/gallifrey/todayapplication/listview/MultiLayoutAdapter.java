package com.gallifrey.todayapplication.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gallifrey.todayapplication.R;

import java.util.List;

public class MultiLayoutAdapter extends BaseAdapter {
    private static final int TYPE_LEFT=0;
    private static final int TYPE_RIGHT=1;
    private List<PersonChat> mData;
    private Context mContext;
    public MultiLayoutAdapter(List<PersonChat> data,Context context){
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


    static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int type=getItemViewType(i);
        ViewHolder viewHolder=null;
        if(view==null){
            switch (type){
                case TYPE_LEFT:
                    view= LayoutInflater.from(mContext).inflate(R.layout.listitem_left,viewGroup,false);
                    break;
                case TYPE_RIGHT:
                    view= LayoutInflater.from(mContext).inflate(R.layout.listitem_right,viewGroup,false);
                    break;
            }
            viewHolder =new ViewHolder();
            viewHolder.imageView=view.findViewById(R.id.item_iv);
            viewHolder.textView=view.findViewById(R.id.item_tv);
            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(mData.get(i).getImageId());
        viewHolder.textView.setText(mData.get(i).getWords());
        return view;
    }

    //行选项布局的数量
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    //行选项布局的类型
    @Override
    public int getItemViewType(int position) {
        if(mData.get(position).getStatus()){
            return TYPE_RIGHT;
        }else {
            return TYPE_LEFT;
        }
    }
}
