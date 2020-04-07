package com.example.deliveryshop.showorder;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.deliveryshop.R;
import com.example.deliveryshop.base.BaseActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ShowOrdersActivity extends BaseActivity implements ShowOrdersView {
    private ShowOrdersPresenter presenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initRecyclerView();
        setupToolbar();
        presenter = new ShowOrdersPresenter(this);
        presenter.generateRetrofitCall();
        addActionButton();
    }

    private void addActionButton() {
        FloatingActionButton floatingActionButton = findViewById(R.id.floating_action_button);
        floatingActionButton.setOnClickListener(view -> {
            presenter.onClick();
        });
    }


    public void navigateToNewActivity() {
        // Intent intent = new Intent(this, AddOrderActivity.class);
        // startActivity(intent);
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
        return R.layout.activity_show_orders;
    }

    @Override
    public void showError() {
        Toast.makeText(ShowOrdersActivity.this, R.string.networking_error, Toast.LENGTH_SHORT).show();
    }
}