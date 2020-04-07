package com.example.deliveryshop.network;

import com.example.deliveryshop.model.Order;
import com.example.deliveryshop.model.OrderList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface GetDataService {
    @POST("products/add")
    Call<OrderList> addProduct(@Body Order order);

    @GET("products")
    Call<OrderList> getAllOrders();

    @PUT("products/update/{id}")
    Call<Order> updateOrder(@Path("id") String id, @Body Order order);

    @DELETE("products/delete/{id}")
    Call<Order> deleteOrder(@Path("id") String id);
}