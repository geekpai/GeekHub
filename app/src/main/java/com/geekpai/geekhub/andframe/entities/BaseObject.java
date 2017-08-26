package com.geekpai.geekhub.andframe.entities;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * description:
 * created by geekpai on 2017/8/26.
 * email: geekpai@qq.com
 */

public class BaseObject implements Serializable {

    public String toJson() {
        return new Gson().toJson(this);
    }

    @Override
    public String toString() {
        return toJson();
    }
}
