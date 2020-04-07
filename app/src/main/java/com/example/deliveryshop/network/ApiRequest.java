package com.example.deliveryshop.network;

public class ApiRequest {
    private static GetDataService api;

    public static GetDataService generateApiRequest() {
        api = RetrofitInstance.getRetrofit().create(GetDataService.class);
        return api;
    }
}
