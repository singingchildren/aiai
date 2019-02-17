package com.example.lastwork.utils;

/**
 * author:${张四佟}
 * date:2019/3/2 9:08
 * description
 */
public interface MyCallBack<T> {

    void setData(T data);
    void setError(T error);

}
