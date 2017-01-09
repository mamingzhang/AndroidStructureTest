package com.example.mamingzhang.androidstructuretest.fragment.glide;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GlideCustomFragment extends BaseFragment {

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
//                .crossFade(1000)
                .animate(android.R.anim.slide_in_left) //动画只在不从缓存中提供时采用。如果图片在缓存内，它应该直接被加载，动画则是没有必要显示的
//                .bitmapTransform(new BlurTransformation(getContext()))
//                .bitmapTransform(new RoundedCornersTransformation(getContext(), 50, 0))
//                .bitmapTransform(new BlurTransformation(getContext(), 25), new CropCircleTransformation(getContext()))
                .priority(Priority.HIGH)
//                .thumbnail(0.1f)
//                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
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
