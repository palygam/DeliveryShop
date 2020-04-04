package com.example.deliveryshop.addorder;

import com.example.deliveryshop.CustomApplication;
import com.example.deliveryshop.model.OrderList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddOrderActivityPresenter {
    private AddOrderActivityView view;

    public AddOrderActivityPresenter(AddOrderActivityView view) {
        this.view = view;
    }

    public void postNewOrderToServer() {
        Call<OrderList> call = CustomApplication.getApi().addNewProduct(view.getNewOrder());
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

    public void onClick() {
        view.navigateToShowProductsActivity();
    }
}
