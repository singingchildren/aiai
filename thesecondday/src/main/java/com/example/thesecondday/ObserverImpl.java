package com.example.thesecondday;

import java.util.Observable;
import java.util.Observer;

/**
 * author:${张四佟}
 * date:2019/2/14 13:58
 * description
 */
public class ObserverImpl implements IObserver {
    @Override
    public void receivMsg(String msg) {
        System.out.println(msg);
    }
}
