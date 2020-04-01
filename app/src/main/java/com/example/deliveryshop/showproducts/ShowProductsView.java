package com.example.deliveryshop.showproducts;

import com.example.deliveryshop.model.Order;

import java.util.List;

public interface ShowProductsView {
    void setupAdapter(List<Order> orders);

    void showError();
}
