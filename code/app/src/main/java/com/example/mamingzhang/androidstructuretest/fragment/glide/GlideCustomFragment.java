package com.example.mamingzhang.androidstructuretest.fragment.glide;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class GlideCustomFragment extends BaseFragment {

    private Unbinder butterKnifeUnBinder;
    @BindView(R.id.glide_image_round)
    ImageView mRoundImageView;
    @BindView(R.id.glide_image_circle)
    ImageView mCircleImageView;
    @BindView(R.id.glide_image_blur)
    ImageView mBlurImageView;
    @BindView(R.id.glide_image_circleblur)
    ImageView mCircleBlurImageView;

    @Override
    protected int getLayouRes() {
        return R.layout.fragment_glide_custom;
    }

    @Override
    protected void initView(View rootView) {
        butterKnifeUnBinder = ButterKnife.bind(this, rootView);
    }

    @Override
    protected void initData() {
        String url = "https://download.withugroup.com/p/g1/M00/FE/93/wKgBPVhuF9CAKwtoAAI4uHYptwY522.jpg";

        Glide.with(this)
                .load(url)
                .bitmapTransform(new RoundedCornersTransformation(getContext(), 50, 0))
                .into(mRoundImageView);

        Glide.with(this)
                .load(url)
                .bitmapTransform(new CropCircleTransformation(getContext()))
                .into(mCircleImageView);

        Glide.with(this)
                .load(url)
                .bitmapTransform(new BlurTransformation(getContext()))
                .into(mBlurImageView);

        Glide.with(this)
                .load(url)
                .bitmapTransform(new BlurTransformation(getContext()), new CropCircleTransformation(getContext()))
                .into(mCircleBlurImageView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (butterKnifeUnBinder != null) {
            butterKnifeUnBinder.unbind();
        }
    }

}
