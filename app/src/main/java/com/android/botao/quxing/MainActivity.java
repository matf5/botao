package com.android.botao.quxing;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.android.botao.R;
import com.iimedia.analytics.MobileClickAgent;
import com.shizhefei.view.indicator.FragmentListPageAdapter;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.ScrollIndicatorView;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

public class MainActivity extends FragmentActivity {
    private Toolbar toolbar;
    private IndicatorViewPager indicatorViewPager;
    private String[] names;
    private ScrollIndicatorView indicator;
    private ViewPager viewPager;
    private LayoutInflater inflate;
    private ImageView add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names = new String[3];

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);//设置导航栏图标
        //toolbar.setLogo(R.mipmap.ic_launcher);//设置app 趣行
        toolbar.setTitle("趣行");//设置主标题
        toolbar.setTitleTextColor(Color.WHITE);
        //toolbar.setSubtitle("Subtitle");//设置子标题
//        toolbar.inflateMenu(R.menu.menu_main);
        init();
        indicator = (ScrollIndicatorView)findViewById(R.id.moretab_indicator);
        viewPager = (ViewPager)findViewById(R.id.moretab_viewPager);
        names[0]="趣行";
        names[1]="聊聊";
        names[2]="榜单";
        setIndicator();

    }
    private void init(){
        add = (ImageView)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,ReleaseActivity.class);
                startActivity(intent);
            }
        });
    }
    private void setIndicator(){
        ColorBar colorBar = new ColorBar(this, Color.rgb(255,255,140), 5);

        indicator.setScrollBar(colorBar);
        indicator.setBackgroundColor(Color.rgb(0, 187, 211));
        //设置导航条属性
        Log.e("main","1");

        int selectColorId = R.color.tab_top_text_2;
        int unSelectColorId = R.color.tab_top_text_1;
        Log.e("main","2");

        indicator.setOnTransitionListener(new OnTransitionTextListener().setColorId(this, selectColorId, unSelectColorId));
        //设置监控颜色
        viewPager.setOffscreenPageLimit(3);
        //设置加载页面数量
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        inflate = LayoutInflater.from(this);

        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));



    }
    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflate.inflate(R.layout.tab_top, container, false);
            }
            TextView textView = (TextView) convertView;

            textView.setText(names[position % names.length]);
            textView.setPadding(20, 0, 20, 0);
            return convertView;
        }

        @Override
        public Fragment getFragmentForPage(int position) {
            android.support.v4.app.Fragment fragment;
           
            fragment = new pipeiFragment();
            if(position==1)
                fragment = new chatFragment();
            if(position==2)
                fragment=new bangdanFragment();
//            Bundle bundle = new Bundle();
//
//            bundle.putInt(pipeiFragment.INTENT_INT_INDEX, position);
//            bundle.putInt(pipeiFragment.SCENE_GROUP_ID, position);
//
//
//            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getItemPosition(Object object) {
            return FragmentListPageAdapter.POSITION_NONE;
        }

    };



    @Override
    protected void onResume() {
        MobileClickAgent.onResume(this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        MobileClickAgent.onPause(this);
        super.onPause();
    }
}
