package com.example.deliveryshop.action;

import com.example.deliveryshop.model.Order;

public interface ActionView {
    void showError();

    void navigateToShowProductsActivity();

    void updateLabels(Order order);

    void editOrder(Order order);
}

