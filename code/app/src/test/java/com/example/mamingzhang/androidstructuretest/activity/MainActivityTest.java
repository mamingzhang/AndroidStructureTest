package com.example.mamingzhang.androidstructuretest.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.compat.BuildConfig;
import android.widget.ListView;

import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.activity.base.BaseFragmentContainerActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import static org.junit.Assert.assertEquals;

/**
 * Created by horsege on 2016/12/24.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class MainActivityTest {
    private Activity mainActivity;

    private ListView listView;

    @Before
    public void setUp() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        listView = (ListView) mainActivity.findViewById(R.id.listView);
    }

    @Test
    public void testStartedActivity() {
        listView.performItemClick(listView, 0, 0);

        ShadowApplication shadowApplication = ShadowApplication.getInstance();
        Intent actualIntent = shadowApplication.getNextStartedActivity();

        Intent expectIntent = new Intent(mainActivity, BaseFragmentContainerActivity.class);

        assertEquals(actualIntent, expectIntent);
    }
}
