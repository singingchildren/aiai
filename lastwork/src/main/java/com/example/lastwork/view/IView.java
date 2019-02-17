package com.example.lastwork.view;

/**
 * author:${张四佟}
 * date:2019/3/2 9:08
 * description
 */
public interface IView<T> {

    void onData(T data);
    void onError(T error);

}
