package com.android.botao.quxing;

import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.botao.R;
import com.android.botao.quxing.adapter.GoodAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public class bangdanFragment extends Fragment {
    private Activity activity;
    private RecyclerView recyclerView;
    private GoodAdapter goodAdapter;
    private List<String> goodsList=new ArrayList<String>();
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity=activity;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadGoods();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bangdan, container, false);
    }
    private void loadGoods() {


        addSomething2Topics();
        goodAdapter = new GoodAdapter(getContext(), goodsList);

        recyclerView = (RecyclerView)getView().findViewById(R.id.recyclerview_scene);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext() , 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(goodAdapter);
    }
    private void addSomething2Topics() {
        goodsList.add("22");
        goodsList.add("22");
        goodsList.add("22");
        goodsList.add("22");
    }
}
