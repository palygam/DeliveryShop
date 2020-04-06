package com.example.deliveryshop.addorder;

import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import com.example.deliveryshop.R;
import com.example.deliveryshop.base.BaseActivity;
import com.example.deliveryshop.model.Delivery;
import com.example.deliveryshop.model.Order;
import com.google.android.material.textfield.TextInputEditText;

public class AddOrderActivity extends BaseActivity implements AddOrderActivityView {
    private AddOrderActivityPresenter presenter;
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
        presenter = new AddOrderActivityPresenter(this);
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
            presenter.postNewOrderToServer(getNewOrder());
            presenter.onClick();
        });
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
        Toast.makeText(AddOrderActivity.this, R.string.networking_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToShowProductsActivity() {
        //  Intent intent = new Intent(this, ShowProductsActivity.class);
        // startActivity(intent);
    }

    public Order getNewOrder() {
        return new Order(new Delivery(
                editTextDeliveryCountry.getText().toString(),
                editTextDeliveryCity.getText().toString()),
                Integer.parseInt(editTextCount.getText().toString()),
                Integer.parseInt(editTextPrice.getText().toString()),
                editTextName.getText().toString(),
                editTextEmail.getText().toString());
    }
}
