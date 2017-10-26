package com.example.simic.udomime;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Simic on 26.10.2017..
 */

public class CatAdapter extends BaseAdapter {

    private ArrayList<Cat> mCatList;

    public CatAdapter(ArrayList<Cat> mCatList) {
        this.mCatList = mCatList;
        this.mCatList.addAll(mCatList);
    }

    @Override
    public int getCount() {
        return this.mCatList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.mCatList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CatAdapter.CatViewAdapter holder;

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cat_item_list,parent,false);
            holder = new CatAdapter.CatViewAdapter(convertView);
            convertView.setTag(holder);
        }else{
            holder = (CatAdapter.CatViewAdapter) convertView.getTag();
        }

        Cat cat = this.mCatList.get(position);

        Picasso.with(parent.getContext())
                .load(cat.getmCatPicure())
                .fit()
                .centerCrop()
                .into(holder.ivDogPic);

        holder.tvDogContact.setText(cat.getmCatDescription());
        holder.tvDogName.setText(cat.getmCatName());
        holder.tvDogDescription.setText(cat.getmCatDescription());

        return convertView;
    }

    static class CatViewAdapter {
        @BindView(R.id.ivCatPic)
        ImageView ivDogPic;
        @BindView(R.id.tvCatName)
        TextView tvDogName;
        @BindView(R.id.tvCatDescription)
        TextView tvDogDescription;
        @BindView(R.id.tvCatContact)
        TextView tvDogContact;

        public CatViewAdapter(View view) {
            ButterKnife.bind(this, view);
        }
    }
}



