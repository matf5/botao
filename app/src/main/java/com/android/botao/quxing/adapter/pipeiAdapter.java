package com.android.botao.quxing.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.botao.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/5/28.
 */
public class pipeiAdapter extends RecyclerView.Adapter<pipeiAdapter.ViewHolder> {

    private Context context;
    private List<View> listViews;

    public  pipeiAdapter(Context context, List<View> listViews) {
        this.context = context;
        this.listViews = listViews;

    }


    @Override
    public pipeiAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewtype) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pipei_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final pipeiAdapter.ViewHolder holder, final int position) {
        if(position==0){
            Picasso.with(context).load(R.drawable.select_page1).into(holder.img_pipei);
        }
        else
            Picasso.with(context).load(R.drawable.select_page2).into(holder.img_pipei);
    }





    public int getItemCount() {
        return listViews.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        public ImageView img_pipei;




        public ViewHolder( View v )
        {
            super(v);
            img_pipei = (ImageView)v.findViewById(R.id.img_pipei);
            v.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if (itemClickListener != null){
                itemClickListener.onItemClick(v, getPosition());
            }
        }

    }
    // 添加Item点击事件接口
    public OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}

