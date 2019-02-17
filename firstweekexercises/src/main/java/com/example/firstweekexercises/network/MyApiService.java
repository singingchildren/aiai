package com.example.firstweekexercises.network;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * author:${张四佟}
 * date:2019/2/12 14:07
 * description
 */
public interface MyApiService {
    @GET
    Observable<ResponseBody> get(@Url String url, @QueryMap Map<String, String> map);
}
