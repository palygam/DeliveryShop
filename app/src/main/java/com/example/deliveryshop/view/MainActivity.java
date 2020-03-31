package com.example.deliveryshop.view;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.deliveryshop.R;
import com.example.deliveryshop.base.BaseActivity;

import java.util.List;


public class MainActivity extends BaseActivity implements MainView {
    private MainPresenter presenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initRecyclerView();
        setupToolbar();
        presenter = new MainPresenter(this);
        presenter.generateRetrofitCall();
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
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setNavigationOnClickListener(v -> onBackPressed());
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showError() {
        Toast.makeText(MainActivity.this, R.string.networking_error, Toast.LENGTH_SHORT).show();
    }
}
