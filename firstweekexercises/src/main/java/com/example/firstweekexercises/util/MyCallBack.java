package com.example.firstweekexercises.util;

/**
 * author:${张四佟}
 * date:2019/2/16 9:43
 * description
 */
public interface MyCallBack<T> {
    void setData(T data);
    void setError(T error);
}
