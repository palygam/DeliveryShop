package com.example.deliveryshop.action;

import com.example.deliveryshop.CustomApplication;
import com.example.deliveryshop.model.Order;
import com.example.deliveryshop.model.OrderList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActionPresenter {
    private ActionView view;

    public ActionPresenter(ActionView view) {
        this.view = view;
    }

    public void addOrder(Order order) {
        Call<OrderList> call = CustomApplication.getApi().addProduct(order);
        call.enqueue(new Callback<OrderList>() {
            @Override
            public void onResponse(Call<OrderList> call, Response<OrderList> response) {
                view.navigateToShowProductsActivity();
            }

            @Override
            public void onFailure(Call<OrderList> call, Throwable t) {
                view.showError();
            }
        });
    }

    public void updateOrder(Order order) {
        Call<Order> call = CustomApplication.getApi().updateOrder(order.getId(), order);
        call.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                view.navigateToShowProductsActivity();
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                view.showError();
            }
        });
    }
}
