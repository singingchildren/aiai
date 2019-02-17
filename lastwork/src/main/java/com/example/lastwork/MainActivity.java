package com.example.lastwork;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.lastwork.fragment.DingDanFragment;
import com.example.lastwork.fragment.GoWuCheFragment;
import com.example.lastwork.fragment.WuYongFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.frame)
    FrameLayout frame;
    @BindView(R.id.xQing)
    TextView xQing;
    @BindView(R.id.goWuche)
    TextView goWuche;
    @BindView(R.id.dDan)
    TextView dDan;
    private FragmentTransaction manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        manager = getSupportFragmentManager().beginTransaction();
        manager.replace(R.id.frame,new WuYongFragment()).commit();

    }

    @OnClick({R.id.xQing, R.id.goWuche, R.id.dDan})
    public void onViewClicked(View view) {
        manager = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.xQing:
                manager.replace(R.id.frame,new WuYongFragment());
                break;
            case R.id.goWuche:
                manager.replace(R.id.frame,new GoWuCheFragment());
                break;
            case R.id.dDan:
                manager.replace(R.id.frame,new DingDanFragment());
                break;
        }
        manager.commit();
    }
}
