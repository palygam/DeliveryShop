package com.example.deliveryshop.inputactivity;

import android.content.Context;
import android.util.Log;
import com.example.deliveryshop.CustomApplication;
import com.example.deliveryshop.model.OrderList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InputActivityPresenter {
    private InputActivityView view;

    public InputActivityPresenter(InputActivityView view) {
        this.view = view;
    }

    public void generateRetrofitCall(Object object) {
        Call<OrderList> call = CustomApplication.getApi().addNewProduct(object);
        call.enqueue(new Callback<OrderList>() {
            @Override
            public void onResponse(Call<OrderList> call, Response<OrderList> response) {
            }

            @Override
            public void onFailure(Call<OrderList> call, Throwable t) {
                view.showError();
            }
        });
    }

    public void onClick(Context context, Class newActivity) {
        view.navigateToNewActivity(context, newActivity);
    }
}
