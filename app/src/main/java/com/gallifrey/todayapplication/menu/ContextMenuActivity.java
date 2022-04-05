package com.gallifrey.todayapplication.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gallifrey.todayapplication.R;

public class ContextMenuActivity extends AppCompatActivity {
    private TextView mTvContext1,mTvContext2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        mTvContext1=findViewById(R.id.tv_context_menu1);
        mTvContext2=findViewById(R.id.tv_context_menu2);

        registerForContextMenu(mTvContext1);
        registerForContextMenu(mTvContext2);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.equals(mTvContext1)){
            //java方式创建contextMenu
            menu.add("context java 1");
            SubMenu f=menu.addSubMenu("context java 2");
            f.add("context java 21");
        }else{
            //xml方式创建contextMenu
            getMenuInflater().inflate(R.menu.context_menu,menu);
        }
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String str=" ";
        switch (item.getItemId()){
            case R.id.context_menu_cut:
                str="context_menu_cut";
                break;
            case R.id.context_menu_paste:
                str="context_menu_paste";
                break;
            default:
                return super.onContextItemSelected(item);
        }
        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
        return true;
    }
}