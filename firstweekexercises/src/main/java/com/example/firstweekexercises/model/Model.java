package com.example.firstweekexercises.model;

import com.example.firstweekexercises.util.MyCallBack;

import java.util.Map;

/**
 * author:${张四佟}
 * date:2019/2/16 9:42
 * description
 */
public interface Model {
    void getData(String mPath, Map<String,String> map,int type, MyCallBack myCallBack);
}
