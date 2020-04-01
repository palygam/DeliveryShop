package com.example.deliveryshop.showproducts;

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
            holder.name.setText(order.getName());
            holder.count.setText(String.valueOf(order.getCount()));
            holder.price.setText(String.valueOf(order.getPrice()));
            if (order.getDelivery() != null) {
                holder.deliveryCountry.setText(String.valueOf(order.getDelivery().getCountry()));
                holder.deliveryCity.setText(String.valueOf(order.getDelivery().getCity()));
        } else {
                holder.deliveryCity.setText((R.string.no_information));
                holder.deliveryCountry.setText((R.string.no_information));
            }
        }
    }

    @Override
    public int getItemCount() {
        if (orders == null)
            return 0;
        return orders.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView count;
        TextView price;
        TextView deliveryCity;
        TextView deliveryCountry;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.order_name);
            count = itemView.findViewById(R.id.order_count);
            price = itemView.findViewById(R.id.order_price);
            deliveryCountry = itemView.findViewById(R.id.delivery_country);
            deliveryCity = itemView.findViewById(R.id.delivery_city);
        }
    }
}