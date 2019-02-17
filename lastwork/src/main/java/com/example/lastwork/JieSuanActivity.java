package com.example.lastwork;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.lastwork.adapter.JsAdapter;
import com.example.lastwork.bea.CarBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JieSuanActivity extends Activity {
    @BindView(R.id.jsRecy)
    RecyclerView jsRecy;
    @BindView(R.id.js_allnum)
    TextView jsAllnum;
    @BindView(R.id.allprice)
    TextView allprice;
    @BindView(R.id.dijiao_btn)
    TextView dijiaoBtn;
    private List<CarBean.ResultBean> beans;
    private JsAdapter jsAdapter;
    private float all = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_suan);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);


    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onShowMessageEvent(List<CarBean.ResultBean> list) {
        /*beans = new ArrayList<>();
        beans.addAll(list);*/
        //Toast.makeText(this,beans.size(),Toast.LENGTH_SHORT).show();
        jsAdapter = new JsAdapter(this);
        jsAdapter.setResultBeans(list);
        jsRecy.setAdapter(jsAdapter);
        jsRecy.setLayoutManager(new LinearLayoutManager(this));
        jsAllnum.setText(list.size()+"");

        for (int i = 0; i < list.size(); i++) {
            all += list.get(i).getPrice();
        }
        allprice.setText(all+"");


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
