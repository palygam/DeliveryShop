package com.example.deliveryshop.addorder;

import com.example.deliveryshop.model.Order;

public interface AddOrderActivityView {
    void showError();

    Order getNewOrder();

    void navigateToShowProductsActivity();
}

