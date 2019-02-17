package com.example.thesecondday;

/**
 * author:${张四佟}
 * date:2019/2/14 13:33
 * description
 */
public interface IObservable {

    void reqisterObserver(IObserver iObserver);
    void removeObserver(IObserver iObserver);
    void notifyMsg();

}
