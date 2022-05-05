package com.gallifrey.todayapplication.tablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gallifrey.todayapplication.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private List<IconRelation> iconRelationList;
    private List<Fragment> fragmentList;
//    private ViewPager viewPager;
//    viewPage已经停止维护，改为使用viewPage2
    private ViewPager2 viewPager2;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        mTabLayout=findViewById(R.id.tab_layout);
//        viewPager=findViewById(R.id.view_pager);
        viewPager2=findViewById(R.id.view_pager2);


        //通过代码动态添加选项卡
//        mTabLayout.addTab(mTabLayout.newTab().setText("tab1"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("tab2"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("tab3"));

        //初始化图标
        initIcon();
        //初始化fragment
        intiFragment();
        //viewPager设置适配器
//        viewPager.setAdapter(new ImageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,fragmentList));
//        mTabLayout.setupWithViewPager(viewPager);

//      viewPage2设置适配器
        viewPager2.setAdapter(new ImageStateAdapter(this,fragmentList));
//      实现viewPage2和tabLayout联动
        new TabLayoutMediator(mTabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setCustomView(getTabView(iconRelationList,position));
            }
        }).attach();

//        for (int i = 0; i <iconRelationList.size(); i++) {
////            mTabLayout.addTab(mTabLayout.newTab());
//            mTabLayout.getTabAt(i).setCustomView(getTabView(iconRelationList,i));
//        }
        //设置默认选项
        mTabLayout.getTabAt(2).select();

        //设置监听
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view=tab.getCustomView();
                ImageView imageView=view.findViewById(R.id.tab_iv);
                TextView textView=view.findViewById(R.id.tab_tv);
                imageView.setSelected(true);
                textView.setTextAppearance(R.style.TabSelectedStyle);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view=tab.getCustomView();
                ImageView imageView=view.findViewById(R.id.tab_iv);
                TextView textView=view.findViewById(R.id.tab_tv);
                imageView.setSelected(false);
                textView.setTextAppearance(R.style.TabUnSelectedStyle);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void intiFragment() {
        fragmentList=new ArrayList<>();
        fragmentList.add(MessageFragment.newInstance(R.drawable.laohu));
        fragmentList.add(MessageFragment.newInstance(R.drawable.ziluolande));
        fragmentList.add(MessageFragment.newInstance(R.drawable.baihe));
        fragmentList.add(MessageFragment.newInstance(R.drawable.classroom));
    }

    private View getTabView(List<IconRelation> data,int position) {
        View view= LayoutInflater.from(this).inflate(R.layout.tab_item,null);
        ImageView imageView=view.findViewById(R.id.tab_iv);
        TextView textView=view.findViewById(R.id.tab_tv);
        imageView.setImageResource(data.get(position).getImageId());
        textView.setText(data.get(position).getName());
        return view;
    }

    private void initIcon() {
        iconRelationList=new ArrayList<>();
        iconRelationList.add(new IconRelation(R.drawable.fl_rb_message_bg,"消息"));
        iconRelationList.add(new IconRelation(R.drawable.fl_rb_phone_bg,"通讯"));
        iconRelationList.add(new IconRelation(R.drawable.fl_rb_discover_bg,"发现"));
        iconRelationList.add(new IconRelation(R.drawable.fl_rb_me_bg,"我的"));
    }
}