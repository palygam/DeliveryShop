package com.example.deliveryshop.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.deliveryshop.R;
import com.example.deliveryshop.model.Order;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Order> orders;

    public Adapter(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Order order = orders.get(position);
        if (order != null) {
            holder.id.setText(order.getId());
            holder.name.setText(order.getName());
            holder.count.setText(String.valueOf(order.getCount()));
            holder.price.setText(String.valueOf(order.getPrice()));
            holder.delivery.setText(order.getDelivery().toString());
        } else {
            holder.id.setText(R.string.no_information);
            holder.name.setText(R.string.no_information);
            holder.count.setText((R.string.no_information));
            holder.price.setText((R.string.no_information));
            holder.delivery.setText((R.string.no_information));
        }
    }

    @Override
    public int getItemCount() {
        if (orders == null)
            return 0;
        return orders.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView name;
        TextView count;
        TextView price;
        TextView delivery;

        public ViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.order_id);
            name = itemView.findViewById(R.id.order_name);
            count = itemView.findViewById(R.id.order_count);
            price = itemView.findViewById(R.id.order_price);
            delivery = itemView.findViewById(R.id.order_delivery);

        }
    }
}