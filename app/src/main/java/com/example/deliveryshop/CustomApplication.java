package com.example.deliveryshop;
import android.app.Application;

import com.example.deliveryshop.network.ApiRequest;
import com.example.deliveryshop.network.GetDataService;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static GetDataService getApi() {
        return ApiRequest.generateApiRequest();
    }
}
