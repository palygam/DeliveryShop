package com.example.deliveryshop.network;

import com.example.deliveryshop.model.Order;
import com.example.deliveryshop.model.OrderList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GetDataService {
    @POST("products/add")
    Call<OrderList> addNewProduct(@Body Order order);

}