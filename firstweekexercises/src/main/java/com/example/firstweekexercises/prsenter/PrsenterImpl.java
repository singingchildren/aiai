package com.example.firstweekexercises.prsenter;

import com.example.firstweekexercises.model.ModelImpl;
import com.example.firstweekexercises.util.MyCallBack;
import com.example.firstweekexercises.view.IView;

import java.util.Map;

/**
 * author:${张四佟}
 * date:2019/2/16 9:46
 * description
 */
public class PrsenterImpl implements Prsenter {

    private IView iView;
    private final ModelImpl model;

    public PrsenterImpl(IView iView) {
        this.iView = iView;
        model = new ModelImpl();
    }

    @Override
    public void startRequest(String mPath, Map<String, String> map,int type) {
        model.getData(mPath, map,type, new MyCallBack() {
            @Override
            public void setData(Object data) {
                iView.onSueecss(data);
            }

            @Override
            public void setError(Object error) {
                iView.onError(error);
            }
        });
    }
}
