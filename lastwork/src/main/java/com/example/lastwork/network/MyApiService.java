package com.example.lastwork.network;

import java.util.Map;


import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * author:${张四佟}
 * date:2019/3/2 9:18
 * description
 */
public interface MyApiService {
    @GET
    Observable<ResponseBody> get(@Url String mPath, @Header("userId") String userId, @Header("sessionId") String sessionId);

    @GET
    Observable<ResponseBody> getxq(@Url String mPath,@QueryMap Map<String,String> map, @Header("userId") String userId, @Header("sessionId") String sessionId);
}
