package com.example.mamingzhang.androidstructuretest.data.manager.basicrealm;

import com.example.mamingzhang.androidstructuretest.data.manager.basicrealm.entity.BasicRealmEntity;
import com.example.mamingzhang.androidstructuretest.utils.DebugUtils;

import java.util.Timer;
import java.util.TimerTask;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by horsege on 2016/12/17.
 * <p>
 * 用于验证基本的Realm更新逻辑操作，愿意用Movie相关进行验证，由于Gson自解析实体和RealmObject
 * 相关数据暂时没办法互通，后期研究后增加
 * <p>
 * 本Manager仅仅是用于验证，从使用上来看并不是很合适，因此单独拉出来
 */

public class BasicRealmDataManager {

    private Timer timer;

    public BasicRealmDataManager() {
        DebugUtils.LogV("BasicRealmDataManager Constructor");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        DebugUtils.LogV("BasicRealmDataManager finalize");
    }

    /**
     * 开始模拟数据
     */
    public void startSimulate() {
        if (timer != null) {
            return;
        }

        DebugUtils.LogV("BasicRealmDataManager startSimulate");

        timer = new Timer();

        //延迟10S，开始重新创建数据
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Realm realm = BasicRealm.getBasicRealm();

                try {
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            DebugUtils.LogV("BasicRealmDataManager create");

                            RealmResults<BasicRealmEntity> realmResults = realm.where(BasicRealmEntity.class).findAll();
                            realmResults.deleteAllFromRealm();

                            for (int index = 0; index < 10; index++) {
                                BasicRealmEntity basicRealmEntity = realm.createObject(BasicRealmEntity.class);
                                basicRealmEntity.title = "标题---" + index;
                            }
                        }
                    });
                } finally {
                    realm.close();
                }
            }
        }, 10 * 1000);

        //间隔30S，删除第一条数据，一直到删除完成
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Realm realm = BasicRealm.getBasicRealm();

                try {
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            DebugUtils.LogV("BasicRealmDataManager delete");

                            RealmResults<BasicRealmEntity> realmResults = realm.where(BasicRealmEntity.class).findAll();

                            if (realmResults.size() > 0) {
                                realmResults.deleteFirstFromRealm();
                            } else {
                                timer.cancel();
                            }
                        }
                    });
                } finally {
                    realm.close();
                }
            }
        }, 30 * 1000, 5 * 1000);
    }

    /**
     * 停止模拟数据
     */
    public void stopSimulate() {
        DebugUtils.LogV("BasicRealmDataManager stopSimulate");

        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
