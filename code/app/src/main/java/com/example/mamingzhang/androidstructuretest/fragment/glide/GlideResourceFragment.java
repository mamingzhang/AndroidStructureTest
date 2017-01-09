package com.example.mamingzhang.androidstructuretest.fragment.glide;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GlideResourceFragment extends BaseFragment {

    private Unbinder butterKnifeUnBinder;
    @BindView(R.id.glide_image)
    ImageView mImageView;

    @Override
    protected int getLayouRes() {
        return R.layout.fragment_glide_img;
    }

    @Override
    protected void initView(View rootView) {
        butterKnifeUnBinder = ButterKnife.bind(this, rootView);
    }

    @Override
    protected void initData() {
        Glide.with(this).load(R.mipmap.ic_launcher).into(mImageView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (butterKnifeUnBinder != null) {
            butterKnifeUnBinder.unbind();
        }
    }

}
