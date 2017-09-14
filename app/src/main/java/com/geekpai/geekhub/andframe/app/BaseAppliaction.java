package com.geekpai.geekhub.andframe.app;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.support.multidex.MultiDex;

/**
 * description:
 * created by geekpai on 2017/8/26.
 * email: geekpai@qq.com
 */

class BaseAppliaction extends Application {

    // classLoader 在加载 APK 的时候限制了class.dex 包含的 Java 方法数，其总数不能超过65535（64K)
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        if (Build.VERSION.SDK_INT < 21) {  //minSdkVersion>=21（android5.0）则不需
            MultiDex.install(this);
        }
    }
}
