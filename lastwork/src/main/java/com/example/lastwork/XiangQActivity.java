package com.example.lastwork;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lastwork.bea.XiangQBean;
import com.example.lastwork.network.Contacts;
import com.example.lastwork.prsenter.IPrsenterImpl;
import com.example.lastwork.view.IView;
import com.recker.flybanner.FlyBanner;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XiangQActivity<T> extends AppCompatActivity implements IView<T>{


    String uid;
    @BindView(R.id.fly)
    FlyBanner fly;
    @BindView(R.id.itemPrice)
    TextView itemPrice;
    @BindView(R.id.itemTitle)
    TextView itemTitle;
    @BindView(R.id.myWeb)
    WebView myWeb;
    private IPrsenterImpl iPrsenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_q);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        Toast.makeText(this, uid + "", Toast.LENGTH_SHORT).show();
        iPrsenter = new IPrsenterImpl(this);
        Map<String,String> map = new HashMap<>();
        map.put("commodityId",uid);
        iPrsenter.startRequest(Contacts.XQ_URL, map, 1, "16", "155149014543516");
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onIdEvent(String id) {

        uid = id;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onData(T data) {
        if (data instanceof XiangQBean){
            XiangQBean xiangQBean = (XiangQBean) data;
            List<String> strings = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                String[] split = xiangQBean.getResult().getPicture().split(",");
                strings.add(split[i]);
            }
            fly.setImagesUrl(strings);
            itemPrice.setText("￥:"+xiangQBean.getResult().getPrice()+".00");
            itemTitle.setText(xiangQBean.getResult().getCommodityName());
            myWeb.loadDataWithBaseURL(null,"<html><head><title> 欢迎您 </title></head>" +
                    "<body><h2>"+xiangQBean.getResult().getDetails()+"</h2></body></html>", "text/html" , "utf-8", null);

        }
    }

    @Override
    public void onError(T error) {

    }
}
