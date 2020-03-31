package com.example.deliveryshop.view;

import com.example.deliveryshop.model.Order;

import java.util.List;

public interface MainView {
    void setupAdapter(List<Order> orders);

    void showError();
}
