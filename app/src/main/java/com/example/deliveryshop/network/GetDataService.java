package com.example.deliveryshop.network;
import com.example.deliveryshop.model.OrderList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/api/v1/products")
    Call<OrderList> getAllOrders();
}