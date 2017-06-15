package com.tarena.groupon.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;


import com.tarena.groupon.R;
import com.tarena.groupon.adapter.MyPagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends FragmentActivity {

    @BindView(R.id.vp_main)
    ViewPager viewPager;
    MyPagerAdapter adapter;

    @BindView(R
            .id.indicator)
    CirclePageIndicator indicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        initViewPager();
    }

    private void initViewPager() {
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);
        //当前运行程序所使用的设备的屏幕密度
        //低密度  ldpi   120px/linch(2.54cm)
        //中密度  mdpi   160px/linch
        //高密度  hdpi   240px/linch
        //很高密度  xhdpi  320px/linch
        //非常高密度   xxhdpi 480px/linch

        //1dp 在中密度屏幕上 1px
        //1dp 在中密度屏幕上 1px
        //1dp 在中密度屏幕上 1px
        //1dp 在非常高密度屏幕上 3px

        //另外一种获得10dp在当前设备上屏幕密度上的像素值的方式



        final float density = getResources().getDisplayMetrics().density;
        indicator.setBackgroundColor(0xFFCCCCCC);
        //10dp在当前设备上所对应的像素值(px)
        indicator.setRadius(10 * density);
        indicator.setPageColor(0x880000FF);
        indicator.setFillColor(0xFF888888);
        indicator.setStrokeColor(0xFF000000);
        indicator.setStrokeWidth(2 * density);

       viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
            if(position==3){
                indicator.setVisibility(View.INVISIBLE);
            }else {
                indicator.setVisibility(View.VISIBLE);
            }
           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });
    }
}
