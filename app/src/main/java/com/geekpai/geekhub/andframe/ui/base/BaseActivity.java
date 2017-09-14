package com.geekpai.geekhub.andframe.ui.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.geekpai.geekhub.andframe.app.AndApplication;

/**
 * description:
 * created by geekpai on 2017/8/26.
 * email: geekpai@qq.com
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Log.e("className=========", this.getClass().getSimpleName());
        AndApplication.getInstance().pushActivity(this);
        int layoutResID = getLayoutResID();
        if (layoutResID != View.NO_ID) {
            setContentView(layoutResID);
            initView();
        }
    }

    protected abstract int getLayoutResID();

    public void initView() {
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AndApplication.getInstance().popActivity(this);
    }
}
