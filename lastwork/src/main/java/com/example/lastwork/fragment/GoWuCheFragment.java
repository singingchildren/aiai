package com.example.lastwork.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lastwork.JieSuanActivity;
import com.example.lastwork.R;
import com.example.lastwork.XiangQActivity;
import com.example.lastwork.adapter.CarAdapter;
import com.example.lastwork.bea.CarBean;
import com.example.lastwork.network.Contacts;
import com.example.lastwork.prsenter.IPrsenterImpl;
import com.example.lastwork.view.IView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class GoWuCheFragment<T> extends Fragment implements IView<T> {


    @BindView(R.id.allCheck)
    CheckBox allCheck;
    @BindView(R.id.allPrice)
    TextView allPrice;
    @BindView(R.id.goJieSuan)
    TextView goJieSuan;
    Unbinder unbinder;
    private View inflate;
    private RecyclerView carRecy;
    private IPrsenterImpl iPrsenter;
    private CarAdapter carAdapter;
    private List<CarBean.ResultBean> list;
    private List<CarBean.ResultBean> xuanZhong;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_go_wu_che, container, false);
        carRecy = inflate.findViewById(R.id.carRecy);
        carAdapter = new CarAdapter(getContext());

        iPrsenter = new IPrsenterImpl(this);
        iPrsenter.startRequest(Contacts.CAR_URL, null, 0, "16", "155149014543516");
        unbinder = ButterKnife.bind(this, inflate);

        carAdapter.setXuanZeListnner(new CarAdapter.XuanZeListnner() {
            @Override
            public void jiSuanPrice(int i) {
                if (list.get(i).isCheck()){
                    list.get(i).setCheck(false);
                    shuaXin();
                }else{
                    list.get(i).setCheck(true);
                    shuaXin();
                }
            }

            @Override
            public void xiangQ(int id) {
                EventBus.getDefault().postSticky(id+"");
                startActivity(new Intent(getContext(), XiangQActivity.class));
            }
        });

        return inflate;
    }

    private void shuaXin(){
        allPrice.setText(carAdapter.allPrice()+"");
        carAdapter.notifyDataSetChanged();
    }

    @Override
    public void onData(T data) {
        if (data instanceof CarBean) {
            CarBean carBean = (CarBean) data;
            if (carBean.getResult() != null) {
                list = new ArrayList<>();

                list.addAll(carBean.getResult());

                carAdapter.setResultBeans(list);
                carRecy.setAdapter(carAdapter);
                carRecy.setLayoutManager(new LinearLayoutManager(getContext()));
            }

        }
    }

    @Override
    public void onError(T error) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.allCheck, R.id.goJieSuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.allCheck:
                for (int i = 0; i < list.size(); i++) {
                    if (allCheck.isChecked()){
                        list.get(i).setCheck(true);
                        shuaXin();
                    }else{
                        list.get(i).setCheck(false);
                        shuaXin();
                    }
                }
                break;
            case R.id.goJieSuan:
                xuanZhong = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).isCheck()){
                        xuanZhong.add(list.get(i));
                    }
                }
                //Toast.makeText(getContext(),"要结算的商品有"+xuanZhong.size()+"条",Toast.LENGTH_SHORT).show();
                EventBus.getDefault().postSticky(xuanZhong);
                startActivity(new Intent(getContext(), JieSuanActivity.class));
                break;
        }
    }
}
