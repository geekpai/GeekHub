package com.geekpai.geekhub.andframe.app;

import android.app.Activity;

import com.geekpai.geekhub.andframe.utils.Util;

import java.util.LinkedList;

/**
 * description:
 * created by geekpai on 2017/8/26.
 * email: geekpai@qq.com
 */

public class AndApplication extends BaseAppliaction {

    private static AndApplication instance;

    public static AndApplication getInstance() {
        return instance;
    }

    private LinkedList<Activity> activityList = new LinkedList<>();

    public void pushActivity(Activity activity) {
        if (activity != null) {
            activityList.add(activity);
        }
    }

    public void popActivity(Activity activity) {
        if (activity != null) {
            activityList.remove(activity);
        }
    }

    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        globalConfig(Util.getMetaData(this, "environment"));
    }
}
