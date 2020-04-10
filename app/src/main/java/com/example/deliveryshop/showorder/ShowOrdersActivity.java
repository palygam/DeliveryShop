package com.example.deliveryshop.showorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deliveryshop.Constants;
import com.example.deliveryshop.R;
import com.example.deliveryshop.action.ActionType;
import com.example.deliveryshop.action.AddOrEditActivity;
import com.example.deliveryshop.base.BaseActivity;
import com.example.deliveryshop.model.Order;

import java.util.List;

public class ShowOrdersActivity extends BaseActivity implements ShowOrdersView {
    private ShowOrdersPresenter presenter;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initRecyclerView();
        setupToolbar();
        presenter = new ShowOrdersPresenter(this);
        presenter.onOrdersLoaded();
        onClick();
        onLongClick();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_order_item:
                Intent intent = new Intent(this, AddOrEditActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constants.ACTION, ActionType.ADD);
                intent.putExtras(bundle);
                startActivity(intent);
                return true;
            case R.id.settings_item:
                //TODO
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void navigateToNewActivity() {
        Intent intent = new Intent(this, AddOrEditActivity.class);
        startActivity(intent);
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setupAdapter(List<Order> list) {
        adapter.add(list);

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

    @Override
    public void onClick() {
        adapter.setOnItemClickListener(v -> {
            Intent intent = new Intent(this, AddOrEditActivity.class);
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            int position = viewHolder.getAdapterPosition();
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constants.ORDER_FOR_UPDATE, adapter.getOrder(position));
            bundle.putSerializable(Constants.ACTION, ActionType.EDIT);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }

    @Override
    public void onLongClick() {
        adapter.setOnItemLongClickListener(v -> {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            int position = viewHolder.getAdapterPosition();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.dialog_delete);
            builder.setNegativeButton(R.string.dialog_no, (dialog, which) -> {
            });
            builder.setPositiveButton(R.string.dialog_yes, (dialog, which) -> {
                presenter.onOrderDeleted(adapter.getOrder(position));
                adapter.removeOrder(position);
            });
            builder.show();
            return true;
        });
    }
}