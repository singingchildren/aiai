package com.example.thesecondday;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * author:${张四佟}
 * date:2019/2/14 13:57
 * description
 */
public class ObservableImpl implements IObservable {
    List<IObserver> list = new ArrayList<>();
    @Override
    public void reqisterObserver(IObserver iObserver) {
        if(iObserver!=null){
            if(list.contains(iObserver)){
                list.add(iObserver);
            }
        }
    }

    @Override
    public void removeObserver(IObserver iObserver) {
        if (iObserver!=null){
            list.remove(iObserver);
        }
    }

    @Override
    public void notifyMsg() {
        if(list!=null&&list.size()>0){
            for (IObserver iObserver: list) {
                iObserver.receivMsg("我是更新的消息");
            }
        }
    }
}
