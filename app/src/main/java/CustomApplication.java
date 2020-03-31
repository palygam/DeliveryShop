package com.example.deliveryshop;

import android.app.Application;

import com.example.deliveryshop.network.GetDataService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CustomApplication extends Application {

    private static GetDataService api;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(GetDataService.class);
    }

    public static GetDataService getApi() {
        return api;
    }
}