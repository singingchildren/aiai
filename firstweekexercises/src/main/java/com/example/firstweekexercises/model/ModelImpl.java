package com.example.firstweekexercises.model;

import com.example.firstweekexercises.bean.GoodsItemBean;
import com.example.firstweekexercises.bean.SousBean;
import com.example.firstweekexercises.util.MyCallBack;
import com.example.firstweekexercises.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.Map;

/**
 * author:${张四佟}
 * date:2019/2/16 9:46
 * description
 */
public class ModelImpl implements Model {
    @Override
    public void getData(String mPath, Map<String, String> map, int type,final MyCallBack myCallBack) {

        if (type==1){
            RetrofitUtil.getInstance().get(mPath,map).setHttpListener(new RetrofitUtil.HttpListener() {
                @Override
                public void onSuccess(String objStr) {
                    SousBean sousBean = new Gson().fromJson(objStr,SousBean.class);
                    myCallBack.setData(sousBean);
                }

                @Override
                public void onError(String error) {

                }
            });
        }else if(type == 2){
            RetrofitUtil.getInstance().get(mPath,map).setHttpListener(new RetrofitUtil.HttpListener() {
                @Override
                public void onSuccess(String objStr) {
                    GoodsItemBean goodsItemBean = new Gson().fromJson(objStr,GoodsItemBean.class);
                    myCallBack.setData(goodsItemBean);
                }

                @Override
                public void onError(String error) {

                }
            });
        }

    }
}
