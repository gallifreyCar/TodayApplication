package com.gallifrey.todayapplication.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.gallifrey.todayapplication.R;

public class ToolbarActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        mToolbar=findViewById(R.id.toolbar);
        //Java代码中设置标题优先级比xml中设置高
        //要设置空标题，必须要在java代码中设置
        //setTitle()必须要在setSupportActionBar()前面才能生效
        mToolbar.setTitle("一级标题");

        setSupportActionBar(mToolbar);

        //监听必须在setSupportActionBar()下面才能生效
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbae_options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String str="";
        switch (item.getItemId()){
            case R.id.toolbar_search:
                str="toolbar_search";
                break;
            case R.id.toolbar_menu_cut:
                str="toolbar_menu_cut";
                break;
            case R.id.toolbar_menu_copy:
                str="toolbar_menu_copy";
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
       return true;
    }
}