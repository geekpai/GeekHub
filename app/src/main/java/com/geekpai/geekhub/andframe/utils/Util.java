package com.geekpai.geekhub.andframe.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/**
 * description:
 * created by geekpai on 2017/8/26.
 * email: geekpai@qq.com
 */

public class Util {

    public static boolean isEmpty(String str) {
        if (str == null || str.equals(""))
            return true;
        return false;
    }

    public static boolean isEmpty(Object str) {
        if (str == null)
            return true;
        return isEmpty(str.toString());
    }

    public static String getMetaData(Context context, String key) {
        String metaDataValue = "";
        if (context == null || isEmpty(key))
            return metaDataValue;
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            metaDataValue = bundle.getString(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return metaDataValue;
    }
}
