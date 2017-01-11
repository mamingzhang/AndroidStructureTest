package com.example.mamingzhang.androidstructuretest.fragment.glide;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GlideTargetFragment extends BaseFragment {

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
        String url = "https://download.withugroup.com/p/g1/M00/FE/93/wKgBPVhuF9CAKwtoAAI4uHYptwY522.jpg";

        Glide.with(this)
                .load(url)
                .into(new ImageViewTarget<GlideDrawable>(mImageView) {
                    @Override
                    protected void setResource(GlideDrawable resource) {
                        mImageView.setImageDrawable(resource.getCurrent());
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
