package com.example.mamingzhang.androidstructuretest.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;

import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.adapter.BaseGlideAdapter;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.Unbinder;

/**
 *
 * https://github.com/bumptech/glide
 *
 * http://www.jianshu.com/p/7610bdbbad17
 */
public class BasicGlideExampleFragment extends BaseFragment {

    private Unbinder butterKnifeUnBinder;

    @BindView(R.id.basicglide_listview)
    ListView basicGlideListView;
    private BaseGlideAdapter adapter;

    @Override
    protected int getLayouRes() {
        return R.layout.fragment_basicglide;
    }

    @Override
    protected void initView(View rootView) {
        butterKnifeUnBinder = ButterKnife.bind(this, rootView);
        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
        rootView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK && getChildFragmentManager().getBackStackEntryCount() > 0) {
                    getChildFragmentManager().popBackStack();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void initData() {
        adapter = new BaseGlideAdapter();
        basicGlideListView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (butterKnifeUnBinder != null) {
            butterKnifeUnBinder.unbind();
        }
    }

    @OnItemClick(R.id.basicglide_listview)
    public void onItemClick(int positon) {
        BaseFragment baseFragment = BaseFragment.newInstance(adapter.ExampleFragment.get(adapter.getItem(positon).toString()));
        if (baseFragment != null) {
            FragmentManager fm = getChildFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragment_container, baseFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft.addToBackStack(null);
            ft.commit();
        }
    }

}
