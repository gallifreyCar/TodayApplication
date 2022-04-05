package com.gallifrey.todayapplication.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.gallifrey.todayapplication.R;

public class PopupMenuActivity extends AppCompatActivity {
    private Button mBtnPopup0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);

        mBtnPopup0 =findViewById(R.id.btn_popup);
        mBtnPopup0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu=new PopupMenu(PopupMenuActivity.this,view);
                popupMenu.getMenuInflater().inflate(R.menu.popupo_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        String str="";
                        switch (menuItem.getItemId()){
                            case R.id.popup_file:
                                str="popup_file";
                                break;
                            case R.id.popup_save:
                                str="popup_save";
                                break;
                            case R.id.popup_search:
                                str="popup_search";
                                break;
                            default:
                                return false;
                        }
                        Toast.makeText(PopupMenuActivity.this,str,Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

    }
}