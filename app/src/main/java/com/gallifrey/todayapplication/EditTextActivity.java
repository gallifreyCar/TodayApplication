package com.gallifrey.todayapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class EditTextActivity extends AppCompatActivity {
    private EditText mEtUser;
    private EditText mEtPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        mEtUser=findViewById(R.id.et_user);
        mEtUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i("EditTextActivity", "onTextChanged: "+charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}