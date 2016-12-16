package com.example.mamingzhang.androidstructuretest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.config.FragmentConfig;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mamingzhang on 16/12/16.
 */

public class MainAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return FragmentConfig.ExampleFragment.size();
    }

    @Override
    public Object getItem(int position) {
        Object[] keySet = FragmentConfig.ExampleFragment.keySet().toArray();
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
