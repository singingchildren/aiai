package com.example.firstweekexercises.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.firstweekexercises.R;
import com.example.firstweekexercises.bean.GoodsItemBean;
import com.example.firstweekexercises.network.Contacts;
import com.example.firstweekexercises.prsenter.PrsenterImpl;
import com.example.firstweekexercises.view.IView;
import com.recker.flybanner.FlyBanner;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SunActivity<T> extends AppCompatActivity implements IView<T> {

    @BindView(R.id.neirong)
    TextView neirong;
    @BindView(R.id.flyBanner)
    FlyBanner flyBanner;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.jieshao)
    TextView jieshao;
    private PrsenterImpl prsenter;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sun);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        prsenter = new PrsenterImpl(this);
        Map<String, String> map = new HashMap<>();
        map.put("commodityId", uid);
        prsenter.startRequest(Contacts.XQ_URL, map, 2);
    }

    @Subscribe(sticky = true)
    public void onEventMainThread(String uid) {
        this.uid = uid;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onSueecss(T data) {
        if (data instanceof GoodsItemBean) {
            GoodsItemBean goodsItemBean = (GoodsItemBean) data;
            String picture = goodsItemBean.getResult().getPicture();
            String[] split = picture.split("[,]");
            List<String> imgesUrl = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                imgesUrl.add(split[i]);
            }
            flyBanner.setImagesUrl(imgesUrl);
            name.setText(goodsItemBean.getResult().getCommodityName());
            neirong.setText(goodsItemBean.getResult().getCategoryName());
            jieshao.setText(goodsItemBean.getResult().getDescribe());

        }
    }

    @Override
    public void onError(T error) {

    }
}
