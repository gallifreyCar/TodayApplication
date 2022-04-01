package com.gallifrey.todayapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToggleSwitchActivity extends AppCompatActivity {
    private TextView mTvTbSw;
    private ToggleButton mTb1,mTb2;
    private Switch mSw1,mSw2;
    private ImageView mIvTbSw;
    private  int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_switch);
        mTb1=findViewById(R.id.tb1);
        mTb2=findViewById(R.id.tb2);
        mSw1=findViewById(R.id.sw1);
        mSw2=findViewById(R.id.sw2);
        mIvTbSw=findViewById(R.id.iv_tbsw);
        mTvTbSw=findViewById(R.id.tv_tbsw);

        MyTbSwCheckedChangeListener myTbSwCheckedChangeListener=new MyTbSwCheckedChangeListener();
        mTb1.setOnCheckedChangeListener(myTbSwCheckedChangeListener);
        mTb2.setOnCheckedChangeListener(myTbSwCheckedChangeListener);

        mSw1.setOnCheckedChangeListener(myTbSwCheckedChangeListener);
        mSw2.setOnCheckedChangeListener(myTbSwCheckedChangeListener);

        mIvTbSw.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String str="";
                count++;
                switch (count%8){
                    case 0:
                        str="FIT_CENTER";
                        mIvTbSw.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        break;
                    case 1:
                        mIvTbSw.setScaleType(ImageView.ScaleType.FIT_START);
                        str="FIT_START";
                        break;
                    case 2:
                        mIvTbSw.setScaleType(ImageView.ScaleType.FIT_END);
                        str="FIT_END";
                        break;
                    case 3:
                        mIvTbSw.setScaleType(ImageView.ScaleType.FIT_XY);
                        str="FIT_XY";
                        break;
                    case 4:
                        mIvTbSw.setScaleType(ImageView.ScaleType.CENTER);
                        str="CENTER";
                        break;
                    case 5:
                        mIvTbSw.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        str="CENTER_CROP";
                        break;
                    case 6:
                        mIvTbSw.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        str="CENTER_INSIDE";
                        break;
                    case 7:
                        mIvTbSw.setScaleType(ImageView.ScaleType.MATRIX);
                        str="MATRIX";
                        Matrix matrix=new Matrix();
                        matrix.setTranslate(100,100);
                        matrix.postRotate(30);
                        mIvTbSw.setImageMatrix(matrix);
                        break;
                }

                mTvTbSw.setText(str);
            }
        });

    }

    private class MyTbSwCheckedChangeListener implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            if(compoundButton==mSw2){
                mIvTbSw.setImageResource(R.mipmap.checkbox_round_1);
//                mIvTbSw.setImageDrawable(getDrawable(R.mipmap.delect));
            }else if(compoundButton==mTb2){
                mIvTbSw.setImageResource(R.drawable.school);
            }else if(compoundButton==mSw1){
                mIvTbSw.setImageResource(R.drawable.longlongt);
            }
            if(compoundButton.isChecked()){
                Toast.makeText(ToggleSwitchActivity.this,"打开",Toast.LENGTH_LONG).show();
            }
        }
    }
}