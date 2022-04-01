package com.gallifrey.todayapplication;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyEditText extends androidx.appcompat.widget.AppCompatEditText {
    public MyEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);
        switch (event.getAction()){
            case KeyEvent.ACTION_DOWN:
                Log.i("MyEditText", "onKeyDown: ");
                break;
        }
        return false;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        super.onKeyUp(keyCode, event);
        switch (event.getAction()){
            case KeyEvent.ACTION_UP:
                Log.i("MyEditText", "onKeyUp: ");
                break;
        }
        return false;
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {

        Log.i("MyEditText", "onFocusChanged: ");

        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }
}
