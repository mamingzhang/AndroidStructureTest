package com.example.mamingzhang.androidstructuretest.fragment.glide;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GlideMovieFragment extends BaseFragment {

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
        String url = "https://v.qirenqiji.com/szjy/cdn/video/47faa81938ccb7a486d153277e29f162.mp4";
        Glide.with(this)
//                .load(Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "/Download/1.mp4")))
                .load(url)
                .downloadOnly(new SimpleTarget<File>() {
                    @Override
                    public void onResourceReady(File resource, GlideAnimation<? super File> glideAnimation) {
                        Glide.with(GlideMovieFragment.this).load(resource).into(mImageView);
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
