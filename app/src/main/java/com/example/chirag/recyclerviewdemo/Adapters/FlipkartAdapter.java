package com.example.chirag.recyclerviewdemo.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chirag.recyclerviewdemo.Model.Flipkart;
import com.example.chirag.recyclerviewdemo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by chirag on 08-Apr-17.
 */

public class FlipkartAdapter extends RecyclerView.Adapter<FlipkartAdapter.FlipkartViewHolder> {

    private Context context;
    private ArrayList<Flipkart> flipkartArrayList = new ArrayList<>();

    public FlipkartAdapter(Context context,ArrayList<Flipkart> flipkartArrayList){
        this.context = context;
        this.flipkartArrayList = flipkartArrayList;
    }
    @Override
    public FlipkartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_flipkart,parent,false);
        return new FlipkartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FlipkartViewHolder holder, int position) {
        Flipkart flipkart = flipkartArrayList.get(position);
        holder.mTvProductName.setText(flipkart.getProductName());
        holder.mTvProductPrice.setText(flipkart.getProductPrice());
        Picasso.with(context).load(flipkart.getImageUrl()).into(holder.mIvProductImage);
    }


    @Override
    public int getItemCount() {
        return flipkartArrayList.size();
    }
    public class FlipkartViewHolder extends RecyclerView.ViewHolder{
        private ImageView mIvProductImage;
        private TextView mTvProductName,mTvProductPrice;

        public FlipkartViewHolder(View itemView) {
            super(itemView);
            mIvProductImage = (ImageView) itemView.findViewById(R.id.iv_product_image);
            mTvProductPrice = (TextView) itemView.findViewById(R.id.tv_product_price);
            mTvProductName = (TextView) itemView.findViewById(R.id.tv_product_name);
        }
    }

}
