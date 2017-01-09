package com.example.mamingzhang.androidstructuretest.fragment.glide;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GlideGifFragment extends BaseFragment {

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
        String url = "https://download.withugroup.com/p/g1/M00/EF/51/wKgBPVfrI6aATufIAAWwAHa07_s973.gif";
        GlideUrl glideUrl = new GlideUrl(url, new LazyHeaders.Builder()
                .addHeader("deviceId", "IMEI869270022017049")
                .addHeader("channelId", "0")
                .addHeader("appVersion", "0.1.5")
                .addHeader("appCode", "withu")
                .addHeader("token", "AlhtqdYD5RAf9MtbHVict7Ww")
                .addHeader("deviceType", "1")
                .addHeader("appid", "10000")
                .addHeader("os", "android Xiaomi MI MAX 6.0.1")
                .build());

        Glide.with(this)
                .load(glideUrl)
                .asGif()
                .into(mImageView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (butterKnifeUnBinder != null) {
            butterKnifeUnBinder.unbind();
        }
    }

}
