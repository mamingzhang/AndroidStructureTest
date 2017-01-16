package com.example.mamingzhang.androidstructuretest.fragment.glide;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.adapter.RecyclerAdapter;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GlideGifFragment extends BaseFragment {

    private Unbinder butterKnifeUnBinder;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected int getLayouRes() {
        return R.layout.fragment_glide_gif;
    }

    @Override
    protected void initView(View rootView) {
        butterKnifeUnBinder = ButterKnife.bind(this, rootView);
    }

    @Override
    protected void initData() {
        List<String> urlList = new ArrayList<>();
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/2016122420463760381.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/2016122420414336169.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/2016122420403545243.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/2016122420345397265.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/2016122420202791823.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/201612242017933811.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/201612242022274585.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/2016122420121846563.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/2016122420131735069.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/2016122120195836033.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/2016122120191195260.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/2016122120175033162.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/2016122420112151690.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/201612212092150053.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/201612212083816044.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/201612202043448185.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/201612202041650802.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/2016122020385981847.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/201612202030121899.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/2016122020224521134.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/201612202085891435.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/2016122020104895816.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/201612202055525531.gif");
        urlList.add("http://upfile2.asqql.com/upfile/2009pasdfasdfic2009s305985-ts/gif_spic/2016-12/2016122019593080346.gif");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        RecyclerAdapter adapter = new RecyclerAdapter(getActivity(), urlList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (butterKnifeUnBinder != null) {
            butterKnifeUnBinder.unbind();
        }
    }

}
