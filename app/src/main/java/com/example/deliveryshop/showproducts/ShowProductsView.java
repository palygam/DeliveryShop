package com.example.deliveryshop.showproducts;

import android.content.Context;

import com.example.deliveryshop.model.Order;

import java.util.List;

public interface ShowProductsView {
    void navigateToNewActivity(Context context, Class nextActivity);
    void setupAdapter(List<Order> orders);
    void showError();
}
