package com.android.botao.quxing.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.botao.R;
import com.android.botao.quxing.bean.ChatContent;

import java.util.List;

/**
 * Created by Administrator on 2016/5/28.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private List<ChatContent> list;
    private Context context;

    public ChatAdapter(List<ChatContent> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_me_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ViewHolder holder, int position) {
        ChatContent chatContent=list.get(position);
        if(chatContent.getIsMe()){
            holder.tv_me.setVisibility(View.VISIBLE);
            holder.tv_him.setVisibility(View.INVISIBLE);
            holder.tv_me.setText(chatContent.getContent());
        }
        else{
            holder.tv_him.setVisibility(View.VISIBLE);
            holder.tv_me.setVisibility(View.INVISIBLE);
            holder.tv_him.setText(chatContent.getContent());
        }

    }
    public   class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_me;
        public TextView tv_him;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_me = (TextView) itemView.findViewById(R.id.tv_me);
            tv_him = (TextView) itemView.findViewById(R.id.tv_him);
        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}
