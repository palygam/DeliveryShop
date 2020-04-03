package com.example.deliveryshop.inputactivity;

import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.deliveryshop.R;
import com.example.deliveryshop.base.BaseActivity;
import com.example.deliveryshop.model.Delivery;
import com.example.deliveryshop.model.Order;
import com.google.android.material.textfield.TextInputEditText;


public class InputActivity extends BaseActivity implements InputActivityView {
    private InputActivityPresenter presenter;
    private TextInputEditText editTextName;
    private TextInputEditText editTextEmail;
    private TextInputEditText editTextCount;
    private TextInputEditText editTextPrice;
    private TextInputEditText editTextDeliveryCountry;
    private TextInputEditText editTextDeliveryCity;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        presenter = new InputActivityPresenter(this);
        setupToolbar();
        initComponents();
        setupInput();
    }

    public void initComponents() {
        editTextName = findViewById(R.id.edit_text_name);
        editTextEmail = findViewById(R.id.edit_text_email);
        editTextCount = findViewById(R.id.edit_text_count);
        editTextPrice = findViewById(R.id.edit_text_price);
        editTextDeliveryCountry = findViewById(R.id.edit_text_delivery_country);
        editTextDeliveryCity = findViewById(R.id.edit_text_delivery_city);
        buttonSave = findViewById(R.id.button_save);
    }

    public void setupInput() {
        buttonSave.setOnClickListener(view -> {
            String name = editTextName.getText().toString();
            int count = Integer.parseInt(editTextCount.getText().toString());
            int price = Integer.parseInt(editTextPrice.getText().toString());
            String country = editTextDeliveryCountry.getText().toString();
            String city = editTextDeliveryCity.getText().toString();
            String email = editTextEmail.getText().toString();
            Order order = new Order(new Delivery(country, city), count, price, name, email);
            presenter.generateRetrofitCall(order);
            //presenter.onClick(this, ShowProductsActivity.class);
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_input;
    }

    @Override
    public void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setNavigationOnClickListener(v -> onBackPressed());
        }
    }

    @Override
    public void showError() {
        Toast.makeText(InputActivity.this, R.string.networking_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToNewActivity(Context context, Class newActivity) {
        Intent intent = new Intent(context, newActivity);
        context.startActivity(intent);
    }
}
