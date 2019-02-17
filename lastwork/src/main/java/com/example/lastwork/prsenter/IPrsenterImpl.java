package com.example.lastwork.prsenter;

import com.example.lastwork.model.ModelImpl;
import com.example.lastwork.utils.MyCallBack;
import com.example.lastwork.view.IView;

import java.util.Map;

/**
 * author:${张四佟}
 * date:2019/3/2 9:12
 * description
 */
public class IPrsenterImpl implements IPrsenter {

    private IView iView;
    private final ModelImpl model;

    public IPrsenterImpl(IView iView) {
        this.iView = iView;
        model = new ModelImpl();
    }

    @Override
    public void startRequest(String mPath, Map<String, String> map, int type, String userId, String sessionId) {
        model.getData(mPath, map, type, userId, sessionId, new MyCallBack() {
            @Override
            public void setData(Object data) {
                iView.onData(data);
            }

            @Override
            public void setError(Object error) {
                iView.onError(error);
            }
        });
    }
}
