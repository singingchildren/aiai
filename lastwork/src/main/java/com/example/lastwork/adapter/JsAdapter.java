package com.example.lastwork.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.lastwork.R;
import com.example.lastwork.bea.CarBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * author:${张四佟}
 * date:2019/3/2 9:35
 * description
 */
public class JsAdapter extends RecyclerView.Adapter<JsAdapter.ViewHolder> {

    private Context context;
    private List<CarBean.ResultBean> resultBeans = new ArrayList<>();

    public JsAdapter(Context context) {
        this.context = context;
    }

    public void setResultBeans(List<CarBean.ResultBean> beans) {
        this.resultBeans = beans;
    }

    @NonNull
    @Override
    public JsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View inflate = View.inflate(context, R.layout.js_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull JsAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.carImg.setImageURI(resultBeans.get(i).getPic());
        viewHolder.carName.setText(resultBeans.get(i).getCommodityName());
        viewHolder.carPrice.setText("￥:"+resultBeans.get(i).getPrice()+".00");
    }

    public float allPrice(){
        float all = 0;
        for (int i = 0; i < resultBeans.size(); i++) {
            if (resultBeans.get(i).isCheck()){
                all += resultBeans.get(i).getPrice();
            }
        }
        return all;
    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView carImg;
        private final TextView carName;
        private final TextView carPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            carImg = itemView.findViewById(R.id.jsImg);
            carName = itemView.findViewById(R.id.jsName);
            carPrice = itemView.findViewById(R.id.jsPrice);
        }
    }
}
