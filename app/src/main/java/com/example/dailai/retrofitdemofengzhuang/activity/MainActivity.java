package com.example.dailai.retrofitdemofengzhuang.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dailai.retrofitdemofengzhuang.R;
import com.example.dailai.retrofitdemofengzhuang.myinterface.MainService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private MainService mainService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final  Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .serializeNulls()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl("xxx")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        mainService = retrofit.create(MainService.class);

    }

    public void onButton(){
        Toast.makeText(this, "点击事件发生了", Toast.LENGTH_SHORT).show();


    }
}
