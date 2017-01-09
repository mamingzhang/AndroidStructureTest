package com.example.mamingzhang.androidstructuretest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;
import com.example.mamingzhang.androidstructuretest.fragment.glide.GlideCustomFragment;
import com.example.mamingzhang.androidstructuretest.fragment.glide.GlideGifFragment;
import com.example.mamingzhang.androidstructuretest.fragment.glide.GlideImageFragment;
import com.example.mamingzhang.androidstructuretest.fragment.glide.GlideResourceFragment;

import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaseGlideAdapter extends BaseAdapter {
    public static final Map<String, Class<? extends BaseFragment>> ExampleFragment;

    static {
        ExampleFragment = new LinkedHashMap<>();
        ExampleFragment.put("Resource", GlideResourceFragment.class);
        ExampleFragment.put("Image", GlideImageFragment.class);
        ExampleFragment.put("Gif", GlideGifFragment.class);
        ExampleFragment.put("Glide", GlideCustomFragment.class);
    }

    @Override
    public int getCount() {
        return ExampleFragment.size();
    }

    @Override
    public Object getItem(int position) {
        Object[] keySet = ExampleFragment.keySet().toArray();
        return keySet[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_main_activity, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.txtView.setText(getItem(position).toString());

        return view;
    }

    static class ViewHolder {
        @BindView(R.id.txtView)
        TextView txtView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
