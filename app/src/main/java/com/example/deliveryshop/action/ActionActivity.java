package com.example.deliveryshop.action;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.deliveryshop.Constants;
import com.example.deliveryshop.R;
import com.example.deliveryshop.base.BaseActivity;
import com.example.deliveryshop.model.Delivery;
import com.example.deliveryshop.model.Order;
import com.example.deliveryshop.showorder.ShowOrdersActivity;
import com.google.android.material.textfield.TextInputEditText;

public class ActionActivity extends BaseActivity implements ActionView {
    private ActionPresenter presenter;
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
        presenter = new ActionPresenter(this);
        setupToolbar();
        initComponents();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        ChooseAction action = (ChooseAction) bundle.getSerializable(Constants.ACTION);
        switch (action) {
            case ADD:
                buttonSave.setOnClickListener(view -> presenter.addOrder(getNewOrder()));
                break;
            case EDIT:
                Order order = (Order) bundle.getSerializable(Constants.ORDER_FOR_UPDATE);
                updateLabels(order);
                editOrder(order);
        break;
    }

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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_order;
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
        Toast.makeText(ActionActivity.this, R.string.networking_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToShowProductsActivity() {
        Intent intent = new Intent(this, ShowOrdersActivity.class);
        startActivity(intent);
    }

    @Override
    public void updateLabels(Order order) {
        if (order.getDelivery() != null) {
            if (order.getDelivery().getCountry() == null) {
                editTextDeliveryCountry.setText("");
            } else {
                editTextDeliveryCountry.setText(order.getDelivery().getCountry().toString());
            }
            if (order.getDelivery().getCity() == null) {
                editTextDeliveryCity.setText("");
            } else {
                editTextDeliveryCity.setText(order.getDelivery().getCity().toString());
            }
        } else {
            editTextDeliveryCountry.setText("");
            editTextDeliveryCity.setText("");
        }
        editTextCount.setText(String.valueOf(order.getCount()));
        editTextPrice.setText(String.valueOf(order.getPrice()));
        editTextName.setText(order.getName());
        editTextEmail.setText(order.getEmail());
    }

    @Override
    public void editOrder(Order order) {
        String orderId = order.getId();
        buttonSave.setOnClickListener(v -> {
            Order orderForUpdate = getNewOrder();
            orderForUpdate.setId(orderId);
            presenter.updateOrder(orderForUpdate);
        });
    }

    private Order getNewOrder() {
        return new Order(new Delivery(
                editTextDeliveryCountry.getText().toString(),
                editTextDeliveryCity.getText().toString()),
                Integer.parseInt(editTextCount.getText().toString()),
                Integer.parseInt(editTextPrice.getText().toString()),
                editTextName.getText().toString(),
                editTextEmail.getText().toString());
    }
}
