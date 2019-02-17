package com.example.firstweekexercises.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firstweekexercises.R;
import com.example.firstweekexercises.adapter.MainAdapter;
import com.example.firstweekexercises.bean.SousBean;
import com.example.firstweekexercises.network.Contacts;
import com.example.firstweekexercises.prsenter.PrsenterImpl;
import com.example.firstweekexercises.view.IView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity<T> extends AppCompatActivity implements IView<T>,MainAdapter.OnClickListenner{

    @BindView(R.id.sous_edit)
    EditText sousEdit;
    @BindView(R.id.sous_btn)
    Button sousBtn;
    @BindView(R.id.xRecy)
    XRecyclerView xRecy;
    private String trim;
    private PrsenterImpl prsenter;
    private Map<String, String> map;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        prsenter = new PrsenterImpl(this);

    }

    @OnClick(R.id.sous_btn)
    public void onViewClicked() {
        trim = sousEdit.getText().toString().trim();
        map = new HashMap<>();
        map.put("keyword",trim);
        map.put("page","1");
        map.put("count","8");
        if(!trim.isEmpty()){
            prsenter.startRequest(Contacts.ZI_URL,map,1);
            Toast.makeText(this,"查询成功",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"输入点东西鸭",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSueecss(T data) {
        if (data instanceof SousBean){
            SousBean sousBean = (SousBean) data;
            if (sousBean.getStatus().equals("0000")){
                mainAdapter = new MainAdapter(this,sousBean.getResult());
                mainAdapter.setListenner(this);
                xRecy.setAdapter(mainAdapter);
                xRecy.setLayoutManager(new GridLayoutManager(this,2));
            }else{
                Toast.makeText(this,"没有更多数据了呢",Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void onError(T error) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void itemClick(int itemId) {
        EventBus.getDefault().postSticky(itemId+"");

        Toast.makeText(this,itemId+"",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, SunActivity.class));
    }
}

