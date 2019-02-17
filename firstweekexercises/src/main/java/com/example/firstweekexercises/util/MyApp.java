package com.example.firstweekexercises.util;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * author:${张四佟}
 * date:2019/2/16 9:12
 * description
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
