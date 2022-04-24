package com.gallifrey.todayapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        mTv=findViewById(R.id.tv7);
//        mTv.getPaint().setFakeBoldText(true);
//        mTv.getPaint().setStrikeThruText(true);
//        mTv.getPaint().setUnderlineText(true);
//        mTv.getPaint().setAntiAlias(true);
        mTv.setText(Html.fromHtml("<u><b><s>www.baidu.com</s>"));

    }
}