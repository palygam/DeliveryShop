package com.example.deliveryshop.network;


import com.example.deliveryshop.model.OrderList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetDataService {

    @GET("products")
    Call<OrderList> getAllOrders();

}