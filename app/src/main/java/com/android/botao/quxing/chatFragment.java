package com.android.botao.quxing;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.android.botao.R;
import com.android.botao.quxing.adapter.pipeiAdapter;
import com.android.botao.quxing.adapter.pipeicAdapter;
import com.android.botao.quxing.bean.ChatPerson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public class chatFragment extends Fragment {
    private Activity activity;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private pipeicAdapter mpipeiAdapter;
    private List<ChatPerson> listviews;
    ChatPerson chatPerson;
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity=activity;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
//        toolbar.setNavigationIcon(R.mipmap.cmenu);//设置导航栏图标
//        //toolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
//        toolbar.setTitle("聊聊");//设置主标题
        load();

    }
    private void load(){
        listviews = new ArrayList<ChatPerson>();

        addSomething2pipei();
        mpipeiAdapter = new pipeicAdapter(getContext(),listviews);

        recyclerView = (RecyclerView)getView().findViewById(R.id.recyclerview_scene);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mpipeiAdapter);
    }
    private void addSomething2pipei(){
        chatPerson = new ChatPerson();
        chatPerson.setName("云凌可");
        chatPerson.setContent("一起去西藏游玩");
        chatPerson.setState("正在进行");
        chatPerson.setResourceId(R.drawable.yunlinke);
        listviews.add(chatPerson);
        chatPerson = new ChatPerson();
        chatPerson.setName("黛西");
        chatPerson.setContent("一起去广州看展览");
        chatPerson.setState("已结束");
        chatPerson.setResourceId(R.drawable.daisy);
        listviews.add(chatPerson);
        chatPerson = new ChatPerson();
        chatPerson.setName("平井坚");
        chatPerson.setContent("一起去听周杰伦演唱会");
        chatPerson.setState("已结束");
        chatPerson.setResourceId(R.drawable.pingjj);
        listviews.add(chatPerson);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }
}
