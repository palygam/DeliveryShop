package com.example.deliveryshop.network;

import com.example.deliveryshop.model.OrderList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("products")
    Call<OrderList> getAllOrders();
}