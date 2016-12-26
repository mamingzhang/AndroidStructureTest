package com.example.mamingzhang.androidstructuretest.fragment;

import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;

/**
 * Created by mamingzhang on 16/12/26.
 * <p>
 * 验证Android Parceler库对序列化的支持
 * <p>
 * 相关参考资料：
 * 1. https://github.com/johncarl81/parceler
 * 2. http://www.jianshu.com/p/2d7ffaa60185
 * 3. http://ryanharter.com/blog/2016/04/08/autovalue-deep-dive/
 * 4. http://ryanharter.com/blog/2016/03/22/autovalue/
 * 5. https://nullpointer.wtf/android/using-retrofit-realm-parceler/
 */

public class BasicParcelerExampleFragment extends BaseFragment {
    @Override
    protected int getLayouRes() {
        return 0;
    }
}
