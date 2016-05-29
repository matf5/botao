package com.android.botao.quxing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.android.botao.R;
import com.android.botao.quxing.adapter.ChatAdapter;
import com.android.botao.quxing.adapter.pipeicAdapter;
import com.android.botao.quxing.bean.ChatContent;
import com.android.botao.quxing.bean.ChatPerson;
import com.iimedia.analytics.MobileClickAgent;
import com.shizhefei.view.indicator.ScrollIndicatorView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/28.
 */
public class ChatDetailActivity extends Activity{
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private ChatContent chatContent;
    private ImageView back;
    private EditText et;
    private ImageView img_menu;
    private int flag=0;
    private List<ChatContent>list = new ArrayList<ChatContent>();
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        back = (ImageView)findViewById(R.id.back);
        et=(EditText)findViewById(R.id.et);
        et.setOnKeyListener(onKey);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        img_menu = (ImageView)findViewById(R.id.img_menu);
        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChatDetailActivity.this,WebViewTaoBaoActivity.class);
                startActivity(intent);
            }
        });
        //toolbar.setNavigationIcon(R.mipmap.cmenu);//设置导航栏图标
        //toolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
        //toolbar.setTitle("聊天");//设置主标题
        //toolbar.setSubtitle("Subtitle");//设置子标题
//        toolbar.inflateMenu(R.menu.menu_main);
        load();

    }
    View.OnKeyListener onKey=new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            // TODO Auto-generated method stub
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                //这里写发送信息的方法
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm.isActive()) {
                    if(flag==0) {
                        flag=1;
                        et.setText("");
                        imm.hideSoftInputFromWindow(
                                v.getApplicationWindowToken(), 0);
                        chatContent = new ChatContent();
                        chatContent.setIsMe(false);
                        chatContent.setContent(et.getText().toString());
                        Log.e("chatqian", Integer.toString(list.size()));
                        list.add(chatContent);
                        Log.e("chathou", Integer.toString(list.size()));
                        chatAdapter.notifyDataSetChanged();
                        return true;

                    }
                    else{
                        flag=0;
                    }
                }

            }
            return false;
        }
    };
    private void load(){


        addSomething2pipei();
        chatAdapter = new ChatAdapter(list,this);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview_scene);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(chatAdapter);
    }
    private void addSomething2pipei(){
        chatContent = new ChatContent();
        chatContent.setContent("你好呀,西藏那边不错噢~");
        chatContent.setIsMe(true);
        list.add(chatContent);
        chatContent = new ChatContent();
        chatContent.setContent("hi,我也觉得,一起过去吧");
        chatContent.setIsMe(false);
        list.add(chatContent);
        chatContent = new ChatContent();
        chatContent.setContent("好,我看看火车票,订下酒店");
        chatContent.setIsMe(true);
        list.add(chatContent);
        chatContent = new ChatContent();
        chatContent.setContent("okayokay");
        chatContent.setIsMe(false);
        list.add(chatContent);
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
