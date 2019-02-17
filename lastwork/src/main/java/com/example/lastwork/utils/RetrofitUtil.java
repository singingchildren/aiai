package com.example.lastwork.utils;

import com.example.lastwork.network.Contacts;
import com.example.lastwork.network.MyApiService;

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
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author:${张四佟}
 * date:2019/3/2 9:15
 * description
 */
public class RetrofitUtil {
    private MyApiService myApiService;
    private RetrofitUtil() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                //配置此客户端，以便在遇到连接问题时重试或不重试。默认情况下，
                //*该客户端从以下问题中悄悄恢复
                .retryOnConnectionFailure(true)
                .build();
        //初始化Retrofit 并结合各种操作
        Retrofit retrofit = new Retrofit.Builder()
                //结合Gson解析
                .addConverterFactory(GsonConverterFactory.create())
                //结合Rxjava
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Contacts.BASE_URL)
                .client(okHttpClient)
                .build();
        //通过Retrofit创建完 这个ApiService 就可以调用方法了
        myApiService = retrofit.create(MyApiService.class);
    }

    public static RetrofitUtil getInstance() {
        return RetroHolder.retro;
    }

    private static class RetroHolder {
        private static final RetrofitUtil retro = new RetrofitUtil();
    }
    public RetrofitUtil get(String url,String userId,String sessionId) {
        myApiService.get(url,userId,sessionId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        return RetrofitUtil.getInstance();
    }

    public RetrofitUtil getxq(String url,Map<String,String> map,String userId,String sessionId) {
        myApiService.getxq(url,map,userId,sessionId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        return RetrofitUtil.getInstance();
    }


    private Observer observer = new Observer<ResponseBody>() {

        @Override
        public void onCompleted() {

        }
        //网络处理失败
        @Override
        public void onError(Throwable e) {
            if (httpListener != null) {
                httpListener.onError(e.getMessage());
            }
        }
        //网络处理成功
        @Override
        public void onNext(ResponseBody responseBody) {
            if (httpListener != null) {
                try {
                    httpListener.onSuccess(responseBody.string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    };

    public interface HttpListener {
        void onSuccess(String jsonStr);

        void onError(String error);
    }

    private HttpListener httpListener;

    public void setHttpListener(HttpListener listener) {
        this.httpListener = listener;
    }
}
