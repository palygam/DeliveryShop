package com.example.deliveryshop.inputactivity;

import android.content.Context;

public interface InputActivityView {
    void showError();

    void navigateToNewActivity(Context context, Class newActivity);
}

