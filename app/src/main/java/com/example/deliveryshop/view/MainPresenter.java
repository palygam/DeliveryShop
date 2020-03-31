package com.example.deliveryshop.view;

import com.example.deliveryshop.CustomApplication;
import com.example.deliveryshop.model.Order;
import com.example.deliveryshop.model.OrderList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private MainView view;
    private List<Order> orders;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void generateRetrofitCall() {
        Call<OrderList> call = CustomApplication.getApi().getAllOrders();
        call.enqueue(new Callback<OrderList>() {
            @Override
            public void onResponse(Call<OrderList> call, Response<OrderList> response) {
                orders = response.body().getData();
                view.setupAdapter(orders);
            }

            @Override
            public void onFailure(Call<OrderList> call, Throwable t) {
                view.showError();
            }
        });
    }
}
