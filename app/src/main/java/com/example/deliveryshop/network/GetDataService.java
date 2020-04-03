package com.example.deliveryshop.network;

import com.example.deliveryshop.model.OrderList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GetDataService {
    @POST("products/add")
    Call<OrderList> addNewProduct(@Body Object object);
}