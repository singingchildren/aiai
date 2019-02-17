package com.example.lastwork.prsenter;

import com.example.lastwork.utils.MyCallBack;

import java.util.Map;

/**
 * author:${张四佟}
 * date:2019/3/2 9:10
 * description
 */
public interface IPrsenter {
    void startRequest(String mPath, Map<String,String> map, int type, String userId, String sessionId);

}
