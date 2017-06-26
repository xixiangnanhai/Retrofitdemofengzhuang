package com.example.dailai.retrofitdemofengzhuang.callback;

import com.example.dailai.retrofitdemofengzhuang.module.BaseBean;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by dailai on 2017/6/26.
 */

public  abstract class MyCallback<T extends BaseBean> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if(response.raw().code()==200){//有合理的返回值
            switch (response.code()){
                case 0://调用接口成功
                    onSuc(response);
                    break;
                case 1://自动登录
                    onAutoLogin();
                    break;
                default://失败的时候提示
                     onFail(response.message());
                    break;

            }

        }



    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

        if(t instanceof SocketTimeoutException){
            //
        }else if(t instanceof ConnectException){
            //
        }else if(t instanceof RuntimeException){
            //
        }
        onFail(t.getMessage());

    }



    public abstract void onSuc(Response<T> response);

    public abstract void onFail(String message);

    public abstract void onAutoLogin();



}
