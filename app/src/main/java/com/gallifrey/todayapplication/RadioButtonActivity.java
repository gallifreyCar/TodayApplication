package com.gallifrey.todayapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {
    private RadioGroup mRgSex,mRgAge;
    private Button mBtnRbOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        mRgAge=findViewById(R.id.rg_age);
        mRgSex=findViewById(R.id.rg_sex);
        mBtnRbOk=findViewById(R.id.btn_rb_ok);
        mRgSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton rb=findViewById(id);
                Toast.makeText(RadioButtonActivity.this,rb.getText(),Toast.LENGTH_LONG).show();
            }
        });

        mBtnRbOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choose="";
                RadioButton rb;
                rb=findViewById(mRgSex.getCheckedRadioButtonId());
                choose+=rb.getText();
                rb=findViewById(mRgAge.getCheckedRadioButtonId());
                choose+="\n"+rb.getText();
                Toast.makeText(RadioButtonActivity.this,choose,Toast.LENGTH_LONG).show();
            }
        });
    }
}