package com.gallifrey.todayapplication.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import com.gallifrey.todayapplication.R;

public class OptionsMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //用java代码方式添加菜单
        menu.add("options1");//默认groupId:0,order:0
        menu.add(0,1,1,"options2");//四个参数分别为 groupId（分组Id）,itemId（组内itemId）,order（出现顺序）,title
        menu.add(0,2,2,"options3");
        menu.add(1,2,4,"options4");
        menu.add(1,1,3,"options5");
//        menu.removeGroup(0); //分组方便管理
        SubMenu f=menu.addSubMenu("sub_options");
        f.add("sub1");
        SubMenu f2=f.addSubMenu("sub1-2");
        f2.add("sub2");


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //用xml文件添加菜单,动态添加菜单
        menu.clear();//清楚之前在Java代码中添加的menu的内容，注释这两行代码可以看到Java中设置menu的效果
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String str="";
        switch (item.getItemId()){
            case R.id.menu_open:
                str="menu_open";
                break;
            case R.id.menu_close:
                str="menu_close";
                break;
            default:
                str="NULL";
                break;
        }
        Toast.makeText(this,str+" Click",Toast.LENGTH_LONG).show();

        return super.onOptionsItemSelected(item);
    }
}