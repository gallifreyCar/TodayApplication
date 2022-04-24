package com.gallifrey.todayapplication.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.gallifrey.todayapplication.R;
import com.gallifrey.todayapplication.listview.Flower;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {
    private GridView mGv;
    private List<Flower> flowerList;
    private List<String> imgNetList;
    public GridViewActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        mGv=findViewById(R.id.gv);
//        initFlower();
//        mGv.setAdapter(new GridFlowerAdapter(flowerList,this));
        initImageNet();
        mGv.setAdapter(new GridFlowerAdapter(imgNetList,this));
    }

    //网络资源的加载
    private void initImageNet() {
        imgNetList=new ArrayList<>();
        imgNetList.add("https://gallifrey.asia/img/kyueki01.webp");
        imgNetList.add("https://gallifrey.asia/img/kyueki02.webp");
        imgNetList.add("https://gallifrey.asia/img/kyueki03.webp");
        imgNetList.add("https://gallifrey.asia/img/kyueki04.webp");
        imgNetList.add("https://gallifrey.asia/img/kyueki05.webp");
        imgNetList.add("https://gallifrey.asia/img/kyueki06.webp");
        imgNetList.add("https://gallifrey.asia/img/kyueki07.webp");
        imgNetList.add("https://gallifrey.asia/img/kyueki08.webp");
        imgNetList.add("https://gallifrey.asia/img/kyueki09.webp");

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