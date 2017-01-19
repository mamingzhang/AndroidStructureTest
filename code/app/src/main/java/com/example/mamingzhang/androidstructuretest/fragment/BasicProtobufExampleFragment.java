package com.example.mamingzhang.androidstructuretest.fragment;

import android.view.View;
import android.widget.TextView;

import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;
import com.example.mamingzhang.androidstructuretest.protobuf.Dinosaur;
import com.example.mamingzhang.androidstructuretest.protobuf.Period;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by mamingzhang on 2017/1/19.
 */

public class BasicProtobufExampleFragment extends BaseFragment {

    private Unbinder butterKnifeUnBinder;

    @BindView(R.id.protobuf_txt)
    TextView protobufTxtView;

    @Override
    protected int getLayouRes() {
        return R.layout.fragment_basicprotobuf;
    }

    @Override
    protected void initView(View rootView) {
        butterKnifeUnBinder = ButterKnife.bind(this, rootView);
    }

    @Override
    protected void initData() {
        Dinosaur dinosaur = new Dinosaur.Builder().name("AndroidStructorTest").period(Period.CRETACEOUS).build();
        byte[] protobufResult = Dinosaur.ADAPTER.encode(dinosaur);

        try {
            Dinosaur dinosaurDecode = Dinosaur.ADAPTER.decode(protobufResult);
            if (dinosaurDecode != null) {
                StringBuilder builder = new StringBuilder();
                builder.append("name = ").append(dinosaurDecode.name);
                builder.append("\n");
                builder.append("period = ").append(dinosaurDecode.period);

                protobufTxtView.setText(builder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (butterKnifeUnBinder != null) {
            butterKnifeUnBinder.unbind();
        }
    }
}
