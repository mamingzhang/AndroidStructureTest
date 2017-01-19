package com.example.mamingzhang.androidstructuretest.fragment.glide;

import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GlideLargeImageFragment extends BaseFragment {

    private Unbinder butterKnifeUnBinder;
    @BindView(R.id.glide_largeimage)
    SubsamplingScaleImageView mImageView;

    @Override
    protected int getLayouRes() {
        return R.layout.fragment_glide_largeimg;
    }

    @Override
    protected void initView(View rootView) {
        butterKnifeUnBinder = ButterKnife.bind(this, rootView);
    }

    @Override
    protected void initData() {
        String url = "http://test-i.qirenqiji.com/6c75d207c90a4303162c16a2c60792db_690_6103.jpg";

        Glide.with(this)
                .load(url)
                .downloadOnly(new SimpleTarget<File>() {
                    @Override
                    public void onResourceReady(File resource, GlideAnimation<? super File> glideAnimation) {
                        mImageView.setImage(ImageSource.uri(resource.getAbsolutePath()));
                    }
                });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (butterKnifeUnBinder != null) {
            butterKnifeUnBinder.unbind();
        }
    }

}
