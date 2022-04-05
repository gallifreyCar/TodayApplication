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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mlv=findViewById(R.id.lv1);
//        ArrayAdapter创建方式一
//        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.car, android.R.layout.simple_expandable_list_item_1);
//        mlv.setAdapter(adapter);

//        ArrayAdapter创建方式二
        List<String> datalist=new LinkedList<>();
        datalist.add("大众");
        datalist.add("丰田");
        datalist.add("福特");
        datalist.add("比亚迪");
        datalist.add("哈弗");
//        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,datalist);
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice,datalist);
        mlv.setAdapter(adapter);
        mlv.addHeaderView(LayoutInflater.from(this).inflate(R.layout.viewhead,null));
        mlv.addFooterView(LayoutInflater.from(this).inflate(R.layout.viewfoot,null));

        mlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this,i+" Clicked",Toast.LENGTH_LONG).show();
            }
        });
    }
}