package com.android.botao.quxing;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.android.botao.R;

/**
 * Created by Administrator on 2016/5/28.
 */
public class BangdanDetailActivity extends Activity {
    private Toolbar toolbar;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangdan_detail);
        back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setNavigationIcon(R.mipmap.cmenu);//设置导航栏图标
        //toolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
       // toolbar.setTitle("榜单详情");//设置主标题
        //toolbar.setSubtitle("Subtitle");//设置子标题
//        toolbar.inflateMenu(R.menu.menu_main);


    }

}
