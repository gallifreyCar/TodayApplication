package com.gallifrey.todayapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {
    private CheckBox mCb1,mCb2,mCb3,mCb4,mCb5,mCb6;
    private Button mBnCbOk;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyCheckBoxListener myCheckBoxListener=new MyCheckBoxListener();
        setContentView(R.layout.activity_check_box);
        mCb1=findViewById(R.id.cb1);
        mCb2=findViewById(R.id.cb2);
        mCb3=findViewById(R.id.cb3);
        mCb4=findViewById(R.id.cb4);
        mCb5=findViewById(R.id.cb5);
        mCb6=findViewById(R.id.cb6);
        mBnCbOk=findViewById(R.id.btn_cb_ok);
        mCb1.setOnCheckedChangeListener(myCheckBoxListener);
        mCb2.setOnCheckedChangeListener(myCheckBoxListener);
        mCb3.setOnCheckedChangeListener(myCheckBoxListener);
        mCb4.setOnCheckedChangeListener(myCheckBoxListener);
        mCb5.setOnCheckedChangeListener(myCheckBoxListener);
        mCb6.setOnCheckedChangeListener(myCheckBoxListener);

        mBnCbOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chooseCb="";
                if(mCb1.isChecked())chooseCb+="\n"+mCb1.getText();
                if(mCb2.isChecked())chooseCb+="\n"+mCb2.getText();
                if(mCb3.isChecked())chooseCb+="\n"+mCb3.getText();
                if(mCb4.isChecked())chooseCb+="\n"+mCb4.getText();
                if(mCb5.isChecked())chooseCb+="\n"+mCb5.getText();
                if(mCb6.isChecked())chooseCb+="\n"+mCb6.getText();
                Toast.makeText(CheckBoxActivity.this,chooseCb,Toast.LENGTH_LONG).show();
            }
        });
    }

    private class MyCheckBoxListener implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(compoundButton.isChecked()){
                Toast.makeText(CheckBoxActivity.this,compoundButton.getText()+"Clicked",Toast.LENGTH_LONG).show();
            }
        }
    }



}