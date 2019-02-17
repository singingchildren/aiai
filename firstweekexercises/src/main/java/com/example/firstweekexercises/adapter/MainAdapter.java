package com.example.firstweekexercises.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firstweekexercises.R;
import com.example.firstweekexercises.activity.MainActivity;
import com.example.firstweekexercises.activity.SunActivity;
import com.example.firstweekexercises.bean.SousBean;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.zip.Inflater;

/**
 * author:${张四佟}
 * date:2019/2/16 10:34
 * description
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private Context context;
    private List<SousBean.ResultBean> resultBeans;

    public MainAdapter(MainActivity tMainActivity, List<SousBean.ResultBean> result) {
        this.context = tMainActivity;
        this.resultBeans = result;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.xrecy_item,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.faceImage.setImageURI(resultBeans.get(i).getMasterPic());
        viewHolder.itemName.setText(resultBeans.get(i).getCommodityName());
        viewHolder.itemPrice.setText("$:"+resultBeans.get(i).getPrice()+".00");
        viewHolder.itemXiaol.setText("已售"+resultBeans.get(i).getSaleNum()+"件");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listenner!=null){
                    listenner.itemClick(resultBeans.get(i).getCommodityId());
                }

                /*EventBus.getDefault().postSticky(resultBeans.get(i).getCommodityId()+"");
                context.startActivity(new Intent(context, SunActivity.class));*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView faceImage;
        private final TextView itemName,itemPrice,itemXiaol;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            faceImage = itemView.findViewById(R.id.face_image);
            itemName = itemView.findViewById(R.id.item_name);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemXiaol = itemView.findViewById(R.id.item_xiaol);
        }
    }

    public interface OnClickListenner{
        void itemClick(int itemId);
    }

    public OnClickListenner listenner;

    public void setListenner(OnClickListenner listenner) {
        this.listenner = listenner;
    }
}
