package com.example.deliveryshop.showorder;

import android.content.Context;

import com.example.deliveryshop.model.Order;

import java.util.List;

public interface ShowOrdersView {
    void navigateToNewActivity();

    void setupAdapter(List<Order> orders);

    void showError();
}
