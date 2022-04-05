package com.gallifrey.todayapplication.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.gallifrey.todayapplication.R;

import java.util.LinkedList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private ListView mlv;
    private List<Flower> flowerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mlv=findViewById(R.id.lv1);
//        ArrayAdapter创建方式一
//        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.car, android.R.layout.simple_expandable_list_item_1);
//        mlv.setAdapter(adapter);

//        ArrayAdapter创建方式二
//        List<String> datalist=new LinkedList<>();
//        datalist.add("大众");
//        datalist.add("丰田");
//        datalist.add("福特");
//        datalist.add("比亚迪");
//        datalist.add("哈弗");
////        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,datalist);
//        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice,datalist);
//        mlv.setAdapter(adapter);
//        mlv.addHeaderView(LayoutInflater.from(this).inflate(R.layout.viewhead,null));
//        mlv.addFooterView(LayoutInflater.from(this).inflate(R.layout.viewfoot,null));
//
//        mlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(ListViewActivity.this,i+" Clicked",Toast.LENGTH_LONG).show();
//            }
//        });

        initFlower();
        FlowerAdapter flowerAdapter=new FlowerAdapter((LinkedList<Flower>) flowerList,this);
        mlv.setAdapter(flowerAdapter);
        mlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                flowerAdapter.remove(i);
                Toast.makeText(ListViewActivity.this,i+" Clicked",Toast.LENGTH_LONG).show();
            }
        });
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