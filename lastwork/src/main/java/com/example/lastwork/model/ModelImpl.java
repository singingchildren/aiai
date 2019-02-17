package com.example.lastwork.model;

import com.example.lastwork.bea.CarBean;
import com.example.lastwork.bea.XiangQBean;
import com.example.lastwork.utils.MyCallBack;
import com.example.lastwork.utils.RetrofitUtil;
import com.google.gson.Gson;

import java.util.Map;

/**
 * author:${张四佟}
 * date:2019/3/2 9:10
 * description
 */
public class ModelImpl implements Model {


    @Override
    public void getData(String mPath, Map<String, String> map, int type, String userId, String sessionId, final MyCallBack myCallBack) {
        if(type == 0){
            RetrofitUtil.getInstance().get(mPath,userId,sessionId).setHttpListener(new RetrofitUtil.HttpListener() {
                @Override
                public void onSuccess(String jsonStr) {
                    CarBean carBean = new Gson().fromJson(jsonStr,CarBean.class);
                    myCallBack.setData(carBean);
                }

                @Override
                public void onError(String error) {

                }
            });
        }else if(type == 1){
            RetrofitUtil.getInstance().getxq(mPath,map,userId,sessionId).setHttpListener(new RetrofitUtil.HttpListener() {
                @Override
                public void onSuccess(String jsonStr) {
                    XiangQBean xiangQBean = new Gson().fromJson(jsonStr,XiangQBean.class);
                    myCallBack.setData(xiangQBean);
                }

                @Override
                public void onError(String error) {

                }
            });
        }
    }
}
