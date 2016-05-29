package com.android.botao.quxing.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.android.botao.quxing.ChatDetailActivity;
import com.android.botao.quxing.bean.ChatPerson;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/5/28.
 */
public class pipeicAdapter extends RecyclerView.Adapter<pipeicAdapter.ViewHolder> {

    private Context context;
    private List<ChatPerson> listViews;

    public  pipeicAdapter(Context context,List<ChatPerson> listViews) {
        this.context = context;
        this.listViews = listViews;

    }


    @Override
    public pipeicAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewtype) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pipeic_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final pipeicAdapter.ViewHolder holder, final int position) {
        Picasso.with(context).load(listViews.get(position).getResourceId()).into(holder.img_head);
        holder.tv_content.setText(listViews.get(position).getContent());
        holder.tv_name.setText(listViews.get(position).getName());
        holder.tv_state.setText(listViews.get(position).getState());
        holder.tv_seedetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.tv_chatwith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ChatDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }





    public int getItemCount() {
        return listViews.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        public ImageView img_head;
        public TextView tv_name;
        public TextView tv_content;
        public TextView tv_state;
        public TextView tv_seedetail;
        public TextView tv_chatwith;



        public ViewHolder( View v )
        {
            super(v);

            img_head = (ImageView) v.findViewById(R.id.img_head);
            tv_name = (TextView) v.findViewById(R.id.tv_name);
            tv_content = (TextView) v.findViewById(R.id.tv_content);
            tv_state = (TextView) v.findViewById(R.id.tv_state);
            tv_seedetail = (TextView) v.findViewById(R.id.tv_seedetail);
            tv_chatwith = (TextView) v.findViewById(R.id.tv_chatwith);
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

