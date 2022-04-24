package com.gallifrey.todayapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import android.widget.RadioGroup;

import com.gallifrey.todayapplication.fragment.DiscoverFragment;
import com.gallifrey.todayapplication.fragment.MeFragment;
import com.gallifrey.todayapplication.fragment.MessageFragment;
import com.gallifrey.todayapplication.fragment.PhoneFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentActivity extends AppCompatActivity implements PhoneFragment.IPhoneCallBack{
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private PhoneFragment phoneFragment;
    private MessageFragment messageFragment;

    private MeFragment meFragment;
    private DiscoverFragment discoverFragment;
    private RadioGroup mRg;
    private List<Fragment> fragmentList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        mRg=findViewById(R.id.fl_rg);

        fragmentManager=getSupportFragmentManager();

        messageFragment =new MessageFragment();
        fragmentList.add(messageFragment);

        hideOtherFragment(messageFragment,true);
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.fl_rb_message:
                        hideOtherFragment(messageFragment,false);
                        break;
                    case R.id.fl_rb_phone:
                        if(phoneFragment==null){
                            phoneFragment=PhoneFragment.newInstance("phone  12315");
                            fragmentList.add(phoneFragment);
                            hideOtherFragment(phoneFragment,true);
                        }else {
                            hideOtherFragment(phoneFragment,false);
                        }
                        break;
                    case R.id.fl_rb_me:
                        if(meFragment==null){
                            meFragment=new MeFragment();
                            fragmentList.add(meFragment);
                            hideOtherFragment(meFragment,true);
                        }else {
                            hideOtherFragment(meFragment,false);
                        }
                        break;
                    case R.id.fl_rb_discover:
                        if(phoneFragment==null){
                            discoverFragment=new DiscoverFragment();
                            fragmentList.add(discoverFragment);
                            hideOtherFragment(discoverFragment,true);
                        }else {
                            hideOtherFragment(discoverFragment,false);
                        }
                        break;
                }
            }
        });

    }
    //隐藏其他fragment
    private void hideOtherFragment(Fragment currentFragment,boolean b){
        fragmentTransaction=fragmentManager.beginTransaction();//创建事务
        if(b) {
            fragmentTransaction.add(R.id.fl_container, currentFragment);//如果从未加入，则将当前Fragment添加到activity
        }

        for(Fragment tempFragment:fragmentList){
            if(tempFragment.equals(currentFragment)){
                fragmentTransaction.show(tempFragment);
            }else {
                fragmentTransaction.hide(tempFragment);
            }
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void setData(String str) {
        setTitle(str);
    }
}