package com.android.botao.quxing;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.Toolbar;

import com.android.botao.R;
import com.iimedia.analytics.MobileClickAgent;
import com.shizhefei.view.indicator.ScrollIndicatorView;

/**
 * Created by Administrator on 2016/5/28.
 */
public class ChatDetailActivity extends Activity{
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.cmenu);//设置导航栏图标
        //toolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
        toolbar.setTitle("Title");//设置主标题
        //toolbar.setSubtitle("Subtitle");//设置子标题
//        toolbar.inflateMenu(R.menu.menu_main);


    }
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
