package com.example.mamingzhang.androidstructuretest.fragment;

import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import com.example.mamingzhang.androidstructuretest.BuildConfig;
import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;
import com.tencent.mars.xlog.Log;
import com.tencent.mars.xlog.Xlog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by mamingzhang on 2017/2/6.
 */

public class BasicXLogExampleFragment extends BaseFragment {

    static {
        System.loadLibrary("stlport_shared");
        System.loadLibrary("marsxlog");
    }

    private Unbinder butterKnifeUnBinder;

    @BindView(R.id.xlog_txt)
    TextView xLogTxtView;

    @Override
    protected int getLayouRes() {
        return R.layout.fragment_basicxlog;
    }

    @Override
    protected void initView(View rootView) {
        butterKnifeUnBinder = ButterKnife.bind(this, rootView);
    }

    @Override
    protected void initData() {
        final String SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
        final String logPath = SDCARD + "/marssample/log";

        //init xlog
        if (BuildConfig.DEBUG) {
            Xlog.appenderOpen(Xlog.LEVEL_DEBUG, Xlog.AppednerModeAsync, "", logPath, "MarsSample");
            Xlog.setConsoleLogOpen(true);

        } else {
            Xlog.appenderOpen(Xlog.LEVEL_INFO, Xlog.AppednerModeAsync, "", logPath, "MarsSample");
            Xlog.setConsoleLogOpen(false);
        }

        Log.setLogImp(new Xlog());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (butterKnifeUnBinder != null) {
            butterKnifeUnBinder.unbind();
        }
    }
}
