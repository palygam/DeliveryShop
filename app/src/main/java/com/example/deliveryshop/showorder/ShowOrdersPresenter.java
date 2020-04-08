package com.example.deliveryshop.showorder;

import com.example.deliveryshop.CustomApplication;
import com.example.deliveryshop.model.Order;
import com.example.deliveryshop.model.OrderList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowOrdersPresenter {
    private ShowOrdersView view;
    private List<Order> orders;

    public ShowOrdersPresenter(ShowOrdersView view) {
        this.view = view;
    }

    public void onOrdersLoaded() {
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

    public void onOrderDeleted(Order order) {
        Call<Order> call = CustomApplication.getApi().deleteOrder(order.getId());
        call.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {

            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                view.showError();
            }
        });
    }

    public void onClick() {
        view.navigateToNewActivity();
    }
}