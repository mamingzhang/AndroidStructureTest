package com.example.mamingzhang.androidstructuretest.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.activity.base.BaseActivity;
import com.example.mamingzhang.androidstructuretest.config.FragmentConfig;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView.setAdapter(new MainAdapter());
    }

    private class MainAdapter extends BaseAdapter {

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
                view = getLayoutInflater().inflate(R.layout.listitem_main_activity, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }

            viewHolder.txtView.setText(getItem(position).toString());

            return view;
        }

        class ViewHolder {
            @BindView(R.id.txtView)
            TextView txtView;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
