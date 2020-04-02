package com.example.deliveryshop.showproducts;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.example.deliveryshop.R;
import com.example.deliveryshop.base.BaseActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class ShowProductsActivity extends BaseActivity implements ShowProductsView {
    private ShowProductsPresenter presenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initRecyclerView();
        setupToolbar();
        presenter = new ShowProductsPresenter(this);
        presenter.generateRetrofitCall();
        addActionButton();
    }

    private void addActionButton() {
        FloatingActionButton floatingActionButton = findViewById(R.id.floating_action_button);
        floatingActionButton.setOnClickListener(view -> {
            //presenter.onClick(this, InputActivity.class);
        });
    }

    @Override
    public void navigateToNewActivity(Context context, Class nextActivity) {
        Intent intent = new Intent(context, nextActivity);
        context.startActivity(intent);
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void setupAdapter(List list) {
        Adapter adapter = new Adapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show_products;
    }

    @Override
    public void showError() {
        Toast.makeText(ShowProductsActivity.this, R.string.networking_error, Toast.LENGTH_SHORT).show();
    }
}
