package com.example.firstweekexercises.util;

import com.example.firstweekexercises.network.Contacts;
import com.example.firstweekexercises.network.MyApiService;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author:${张四佟}
 * date:2019/2/12 13:57
 * description
 */
public class RetrofitUtil {

    private final MyApiService myApiService;

    private RetrofitUtil() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .retryOnConnectionFailure(true)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Contacts.BASE_URL)
                .client(okHttpClient)
                .build();
        myApiService = retrofit.create(MyApiService.class);
    }

    public static RetrofitUtil getInstance(){
        return RetrofitHolder.UTIL;
    }

    private static class RetrofitHolder{
        private static final RetrofitUtil UTIL = new RetrofitUtil();
    }

    public RetrofitUtil get(String url, Map<String,String> map){
        myApiService.get(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        return RetrofitUtil.getInstance();
    }

    private Observer observer = new Observer<ResponseBody>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            if(httpListener != null){
                httpListener.onError(e.getMessage());
            }
        }

        @Override
        public void onNext(ResponseBody responseBody) {
            if(httpListener != null){
                try {
                    httpListener.onSuccess(responseBody.string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    public interface HttpListener{
        void onSuccess(String objStr);
        void onError(String error);
    }

    private HttpListener httpListener;

    public void setHttpListener(HttpListener listener){
        this.httpListener = listener;
    }

}
