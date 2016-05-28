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
 * Created by Administrator on 2016/4/7.
 */
public class GoodAdapter extends RecyclerView.Adapter<GoodAdapter.ViewHolder> {



private Context context;
private List<String> goodsList;

public GoodAdapter(Context context, List<String> goodsList) {
        this.context = context;
        this.goodsList = goodsList;

        }


    @Override
    public GoodAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewtype) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.good_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final GoodAdapter.ViewHolder holder, final int position) {


        if(position==0) {
            holder.tv_price.setText("2400人");
            //Log.e("GoodAdapter", Double.toString(good.getPrice()));
            Picasso.with(context).load(R.drawable.list1).into(holder.img_good);



            holder.cb_zan.setChecked(true);

        }
        if(position==1) {
            holder.tv_price.setText("22400人");
            //Log.e("GoodAdapter", Double.toString(good.getPrice()));
            Picasso.with(context).load(R.drawable.list2).into(holder.img_good);



            holder.cb_zan.setChecked(false);

        }
        if(position==2) {
            holder.tv_price.setText("122400人");
            //Log.e("GoodAdapter", Double.toString(good.getPrice()));
            Picasso.with(context).load(R.drawable.list3).into(holder.img_good);



            holder.cb_zan.setChecked(true);

        }
        if(position==3) {
            holder.tv_price.setText("122人");
            //Log.e("GoodAdapter", Double.toString(good.getPrice()));
            Picasso.with(context).load(R.drawable.list4).into(holder.img_good);



            holder.cb_zan.setChecked(false);

        }

    }




    @Override
    public int getItemCount() {
        return goodsList.size();
    }
    public  static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView img_good;
        public TextView tv_good_name;
        public TextView tv_price;
        public TextView text_zan;
        public CheckBox cb_zan;



        public ViewHolder( View v )
        {
            super(v);

            img_good = (ImageView) v.findViewById(R.id.img_good);

            tv_price = (TextView) v.findViewById(R.id.tv_price);

            cb_zan = (CheckBox) v.findViewById(R.id.cb_zan);
            Log.d("goodpter","加载UI");
        }

    }
}
