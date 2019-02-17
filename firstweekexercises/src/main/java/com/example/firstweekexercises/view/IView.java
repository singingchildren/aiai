package com.example.firstweekexercises.view;

/**
 * author:${张四佟}
 * date:2019/2/16 9:44
 * description
 */
public interface IView<T> {
    void onSueecss(T data);
    void onError(T error);
}
