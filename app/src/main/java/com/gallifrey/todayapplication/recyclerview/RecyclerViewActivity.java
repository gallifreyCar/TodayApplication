package com.gallifrey.todayapplication.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.gallifrey.todayapplication.R;
import com.gallifrey.todayapplication.listview.Flower;

import java.util.LinkedList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRv;
    private List<Flower> flowerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        initFlower();
        mRv=findViewById(R.id.rv);

//        测试线性布局管理器
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        mRv.setLayoutManager(linearLayoutManager);

//        测试网格布局管理器
//        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
//        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
//        mRv.setLayoutManager(gridLayoutManager);

//        测试瀑布流布局管理器 垂直方向
//        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//        mRv.setLayoutManager(staggeredGridLayoutManager);
//        测试瀑布流布局管理器 水平方向
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
        mRv.setLayoutManager(staggeredGridLayoutManager);


//      设置适配器
        mRv.setAdapter(new RecyclerFlowerAdapter(flowerList,this));

    }


    private void initFlower() {
        flowerList=new LinkedList<>();
        flowerList.add(new Flower(R.drawable.baihe,"百合","百年好合"));
        flowerList.add(new Flower(R.drawable.rose,"红玫瑰","富有热情"));
        flowerList.add(new Flower(R.drawable.yinghua,"樱花","幸福永远"));
        flowerList.add(new Flower(R.drawable.sunflower,"向日葵","光辉忠诚"));
        flowerList.add(new Flower(R.drawable.ziluolan,"紫罗兰","永恒的美与爱"));
        flowerList.add(new Flower(R.drawable.jidanhua,"鸡蛋花","孕育希望复活"));

        flowerList.add(new Flower(R.drawable.baihe,"百合22","百年好合"));
        flowerList.add(new Flower(R.drawable.rose,"红玫瑰22","富有热情"));
        flowerList.add(new Flower(R.drawable.yinghua,"樱花22","幸福永远"));
        flowerList.add(new Flower(R.drawable.sunflower,"向日葵22","光辉忠诚"));
        flowerList.add(new Flower(R.drawable.ziluolan,"紫罗兰22","永恒的美与爱"));
        flowerList.add(new Flower(R.drawable.jidanhua,"鸡蛋花22","孕育希望复活"));
    }
}