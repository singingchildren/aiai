package com.example.firstday;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.one)
    Button one;
    @BindView(R.id.two)
    Button two;
    @BindView(R.id.three)
    Button three;
    @BindView(R.id.four)
    Button four;
    @BindView(R.id.five)
    Button five;
    @BindView(R.id.six)
    Button six;
    @BindView(R.id.qi)
    Button qi;
    @BindView(R.id.ba)
    Button ba;
    private SimpleDraweeView tupian;
    private RoundingParams roundingParams;
    private Uri parse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tupian = findViewById(R.id.tupian);
        parse = Uri.parse("https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1067701724,1703565986&fm=58&bpow=438&bpoh=439");
        tupian.setImageURI(parse);

        roundingParams = RoundingParams.fromCornersRadius(5f);
    }

    @OnClick({R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.qi, R.id.ba})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.one:

                roundingParams.setCornersRadius(20);
                tupian.getHierarchy().setRoundingParams(roundingParams);
                tupian.setImageURI(parse);
                break;
            case R.id.two:
                roundingParams.setRoundAsCircle(true);
                tupian.getHierarchy().setRoundingParams(roundingParams);
                tupian.setImageURI(parse);
                break;
            case R.id.three:
                tupian.setAspectRatio(1.5f);

                break;
            case R.id.four:
                break;
            case R.id.five:
                break;
            case R.id.six:
                //https://n.sinaimg.cn/tech/gif/160407/160425_loading.gif
                Uri gif = Uri.parse("https://n.sinaimg.cn/tech/transform/660/w400h260/20190211/A8Pw-hswimzx9168744.gif");
                AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                        //图片地址
                        .setUri(gif)
                        //播放gif 图片
                        .setAutoPlayAnimations(true)
                        //点击重新加载时 可以重新加载4 次
                        .setTapToRetryEnabled(true)
                        .build();

                tupian.setController(controller);
                break;
            case R.id.qi:
                break;
            case R.id.ba:
                break;
        }
    }
}
