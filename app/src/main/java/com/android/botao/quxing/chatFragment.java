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
    private List<View> listviews;
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity=activity;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.cmenu);//设置导航栏图标
        //toolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
        toolbar.setTitle("聊聊");//设置主标题
        load();

    }
    private void load(){
        listviews = new ArrayList<View>();

        addSomething2pipei();
        mpipeiAdapter = new pipeicAdapter(getContext(),listviews);
        mpipeiAdapter.setOnItemClickListener(new pipeicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(),ChatDetailActivity.class);
                startActivity(intent);
            }
        });
        recyclerView = (RecyclerView)getView().findViewById(R.id.recyclerview_scene);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mpipeiAdapter);
    }
    private void addSomething2pipei(){
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.select_page1);
        listviews.add(imageView);
        ImageView imageView1 = new ImageView(getContext());
        imageView1.setImageResource(R.drawable.select_page2);
        listviews.add(imageView1);
        listviews.add(imageView1);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }
}
