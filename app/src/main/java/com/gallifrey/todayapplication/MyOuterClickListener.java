package com.gallifrey.todayapplication;

import android.view.View;
import android.widget.Toast;

public class MyOuterClickListener implements View.OnClickListener {
    private MainActivity mainActivity;
    public MyOuterClickListener(MainActivity activity){
        mainActivity=activity;
    }
    @Override
    public void onClick(View view) {
        Toast.makeText(mainActivity,"Outer Click", Toast.LENGTH_LONG).show();
    }
}
