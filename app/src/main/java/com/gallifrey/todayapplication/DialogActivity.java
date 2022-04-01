package com.gallifrey.todayapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {
    private Button mBtnNormal, mBtnList, mBtnSingle, mBtnMulti, mBtnEdit, mBtnCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mBtnNormal = findViewById(R.id.btn_normal);
        mBtnList = findViewById(R.id.btn_list);
        mBtnSingle = findViewById(R.id.btn_single);
        mBtnMulti = findViewById(R.id.btn_multi);
        mBtnEdit = findViewById(R.id.btn_edit);
        mBtnCustom = findViewById(R.id.btn_custom);

        MyDialogClickListener myDialogClickListener = new MyDialogClickListener();
        mBtnCustom.setOnClickListener(myDialogClickListener);
        mBtnNormal.setOnClickListener(myDialogClickListener);
        mBtnSingle.setOnClickListener(myDialogClickListener);
        mBtnEdit.setOnClickListener(myDialogClickListener);
        mBtnMulti.setOnClickListener(myDialogClickListener);
        mBtnList.setOnClickListener(myDialogClickListener);
    }


    private class MyDialogClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_normal:
                    normalDialog();
                    break;
                case R.id.btn_list:
                    listDialog();
                    break;
                case R.id.btn_single:
                    singleDialog();
                    break;
                case R.id.btn_multi:

                    break;
                case R.id.btn_edit:

                    break;
                case R.id.btn_custom:


            }
        }
        
    }

    private void singleDialog() {
        String[] items ={"优秀","良好","合格","不合格"};
        AlertDialog.Builder singleD=new AlertDialog.Builder(this);
        final int[] choice = new int[1];
        singleD.setIcon(R.mipmap.icon_dialog)
                .setTitle("单选对话框")
                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        choice[0] =i;

                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DialogActivity.this,"单选结果： "+items[choice[0]],Toast.LENGTH_LONG).show();
            }
        }).show();
    }

    private void listDialog() {
        String[] items={"梅花","杏花","桃花","荷花","蔷薇","烟花"};
        AlertDialog.Builder listD=new AlertDialog.Builder(this);
        listD.setIcon(R.mipmap.icon_dialog2)
                .setTitle("列表对话框")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this,"花: "+items[i],Toast.LENGTH_LONG).show();
                    }
                }).show();

    }


    private void normalDialog() {
        AlertDialog.Builder normalD = new AlertDialog.Builder(this);
        normalD.setIcon(R.mipmap.icon_dialog)
                .setTitle("普通对话框")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this, "Ok", Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DialogActivity.this, "OK", Toast.LENGTH_LONG).show();
            }
        }).setNeutralButton("再看看", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DialogActivity.this, "OK", Toast.LENGTH_LONG).show();
            }
        }).show();
    }
}