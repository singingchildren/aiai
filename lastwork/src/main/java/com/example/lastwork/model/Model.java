package com.example.lastwork.model;

import com.example.lastwork.utils.MyCallBack;

import java.util.Map;

/**
 * author:${张四佟}
 * date:2019/3/2 9:08
 * description
 */
public interface Model {
    void getData(String mPath, Map<String,String> map, int type, String userId, String sessionId, MyCallBack myCallBack);
}
