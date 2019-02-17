package com.example.pilisi;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView frseco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frseco = findViewById(R.id.frseco);
        Uri parse = Uri.parse("http://p5.so.qhimgs1.com/bdr/200_200_/t01fadcf3cc106e7afb.jpg");
        frseco.setImageURI(parse);

    }
}
