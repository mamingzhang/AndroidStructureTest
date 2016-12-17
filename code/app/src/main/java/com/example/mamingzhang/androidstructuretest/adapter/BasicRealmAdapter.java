package com.example.mamingzhang.androidstructuretest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.data.manager.basicrealm.entity.BasicRealmEntity;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by horsege on 2016/12/17.
 */

public class BasicRealmAdapter extends BaseAdapter {

    private RealmResults<BasicRealmEntity> basicRealmEntities;

    public BasicRealmAdapter(RealmResults<BasicRealmEntity> basicRealmEntities) {
        this.basicRealmEntities = basicRealmEntities;
    }

    @Override
    public int getCount() {
        return basicRealmEntities.size();
    }

    @Override
    public Object getItem(int i) {
        return basicRealmEntities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_basic_realm, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        BasicRealmEntity basicRealmEntity = (BasicRealmEntity) getItem(i);

        viewHolder.txtView.setText(basicRealmEntity.title);

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
