package com.gallifrey.todayapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG="MainActivityLife";
    private TextView mTv;
    private MyApplication myApplication;
    private Button mBtnEvent,mBtnTextView,mBtnButton,mBtnEditText,mBtnRadioButton,mBtnCheckBox,mBtnTbSw;
    private Button mBtnDialog,mBtnFragment;
    private MyButton myButton;
    private  MyEditText myEditText;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: ");

        //txt文件加载  --Assets
//        try {
//            InputStream inputStream=getAssets().open("temp.txt");
//            byte[] buffer=new byte[1024];
//            ByteArrayOutputStream baos=new ByteArrayOutputStream();
//            int len=-1;
//            while((len= inputStream.read(buffer))!=-1){
//                baos.write(buffer,0,len);
//            };
//            Log.i(TAG, "onCreate: "+baos.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //音频文件加载
//        try {
//            AssetFileDescriptor afd=getAssets().openFd("music/jsr.mp3");
//            MediaPlayer mediaPlayer=new MediaPlayer();
//            mediaPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
//            mediaPlayer.prepare();
//            mediaPlayer.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //图片文件加载
//        try {
//            InputStream is2=getAssets().open("picture/down.jpg");
//            Bitmap bm= BitmapFactory.decodeStream(is2);
//            ImageView iv=findViewById(R.id.down);
//            iv.setImageBitmap(bm);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //网页资源加载
//        WebView wv=findViewById(R.id.wv);
//        wv.loadUrl("file:///android_asset/web/aBubble.html");


        //测试MyApplication
        myApplication=(MyApplication) getApplication();
        Log.i(TAG, "onCreate: "+myApplication.getName());
        myApplication.setName("教室");
        Log.i(TAG, "onCreate: "+myApplication.getName());
        //文本资源
//        mTv=findViewById(R.id.tv);
//        mTv=findViewById(R.id.tv2);
//        mTv.setBackground(getDrawable(R.drawable.school));
//        mTv.setTextColor(getColor(R.color.pink));
//        mTv.setTextSize(getResources().getDimension(R.dimen.fontsize));
//        mTv.setTextAppearance(R.style.blue_textview);


        myEditText=findViewById(R.id.my_edit);
        mBtnEvent=findViewById(R.id.btn_event);
        myButton=findViewById(R.id.my_button);
        myButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.i(TAG, "onTouch: "+"Listener");
                        break;
                }
                return false;
            }
        });

//         Activity本身实现类监听
//        mBtnEvent.setOnClickListener(this);
//        匿名内部类实现监听
//        mBtnEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this,"匿名内部类 clik",Toast.LENGTH_LONG).show();
//            }
//        });
//        内部类实现监听
//        mBtnEvent.setOnClickListener(new MyInnerListener());
//        外部类实现监听
//        mBtnEvent.setOnClickListener(new MyOuterClickListener(this));

        MyClickListener myClickListener=new MyClickListener();


        mBtnTextView=findViewById(R.id.btn_textview);
        mBtnTextView.setOnClickListener(myClickListener);
//        mBtnTextView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this,TextViewActivity.class);
//                startActivity(intent);
//            }
//        });

        mBtnButton=findViewById(R.id.btn_button);
        mBtnButton.setOnClickListener(myClickListener);
//        mBtnButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this,ButtonActivity.class);
//                startActivity(intent);
//            }
//        });

        mBtnEditText=findViewById(R.id.btn_edittext);
        mBtnEditText.setOnClickListener(myClickListener);

        mBtnRadioButton=findViewById(R.id.btn_radiobutton);
        mBtnRadioButton.setOnClickListener(myClickListener);

        mBtnCheckBox=findViewById(R.id.btn_checkbox);
        mBtnCheckBox.setOnClickListener(myClickListener);

        mBtnTbSw=findViewById(R.id.btn_tbsw);
        mBtnTbSw.setOnClickListener(myClickListener);

        mBtnDialog =findViewById(R.id.btn_dialog);
        mBtnDialog.setOnClickListener(myClickListener);

        mBtnFragment=findViewById(R.id.btn_fragment);
        mBtnFragment.setOnClickListener(myClickListener);

        }

    class MyClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent=null;
            switch (view.getId()){
                case R.id.btn_textview:
                    intent=new Intent(MainActivity.this,TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    intent=new Intent(MainActivity.this,ButtonActivity.class);
                    break;
                case R.id.btn_edittext:
                    intent=new Intent(MainActivity.this,EditTextActivity.class);
                    break;
                case R.id.btn_radiobutton:
                    intent=new Intent(MainActivity.this,RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                    intent=new Intent(MainActivity.this,CheckBoxActivity.class);
                    break;
                case R.id.btn_tbsw:
                    intent=new Intent(MainActivity.this,ToggleSwitchActivity.class);
                    break;
                case R.id.btn_dialog:
                    intent=new Intent(MainActivity.this,DialogActivity.class);
                    break;
                case R.id.btn_fragment:
                    intent=new Intent(MainActivity.this,FragmentActivity.class);
                            break;
                default:
                    throw new IllegalArgumentException("null pointer");
            }
            startActivity(intent);
        }
    }


    public void showToast(View view) {
        Toast.makeText(this,"Layout Click",Toast.LENGTH_LONG).show();
    }

    //        内部类实现监听
    class MyInnerListener implements View.OnClickListener{
    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this,"内部类clik",Toast.LENGTH_LONG).show();
    }
}


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this,"Activity clik",Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "onTouchEvent: ");
                break;
            

        }
        return false;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        super.onKeyUp(keyCode, event);
        switch (event.getAction()){
            case KeyEvent.ACTION_UP:
                Log.i(TAG, "onKeyUp: ");
                break;
        }
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
         super.onKeyDown(keyCode, event);
        switch (event.getAction()){
            case KeyEvent.ACTION_DOWN:
                Log.i(TAG, "onKeyDown: ");
                break;
        }
        return false;


    }
}