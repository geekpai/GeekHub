package com.geekpai.geekhub.andframe.app;

import android.content.Context;
import android.os.StrictMode;

import com.geekpai.geekhub.BuildConfig;
import com.geekpai.geekhub.andframe.entities.BaseObject;

/**
 * description:
 * created by geekpai on 2017/8/26.
 * email: geekpai@qq.com
 */

public class AppBuildconfig extends BaseObject {

    private String applicationId;
    private String baseUrl;

    private boolean debugMode;
    private String environment;

    public void globalConfig(Context context, String environment) {
        this.environment = environment;
        applicationId = context.getPackageName().replace(environment.equals("") ? environment : "." + environment, "");
        baseUrl = BuildConfig.BASE_URL;
        debugMode = BuildConfig.DEBUG;
        if (!Environment.ENVIRONMENT_RELEASE.equals(environment)) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyDialog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());

        }
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
