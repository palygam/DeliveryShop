package com.example.deliveryshop.showorder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deliveryshop.R;
import com.example.deliveryshop.model.Order;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<Order> orders;
    private View.OnClickListener mItemClickListener;
    private View.OnLongClickListener mItemLongClickListener;

    public Adapter() {
        this.orders = new ArrayList<>();
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Order order = orders.get(position);
        holder.nameTextView.setText(order.getName());
        holder.countTextView.setText(String.valueOf(order.getCount()));
        holder.priceTextView.setText(String.valueOf(order.getPrice()));
        if (order.getDelivery() != null) {
            holder.deliveryCountryTextView.setText(String.valueOf(order.getDelivery().getCountry()));
            holder.deliveryCityTextView.setText(String.valueOf(order.getDelivery().getCity()));
        } else {
            holder.deliveryCityTextView.setText((R.string.no_information));
            holder.deliveryCountryTextView.setText((R.string.no_information));
        }
    }
    public void add(List<Order> users) {
        orders = users;
        notifyDataSetChanged();
    }


    public Order getOrder(int position) {
        return orders.get(position);
    }

    public void removeOrder(int position) {
        orders.remove(position);
        notifyItemChanged(position);
    }


    @Override
    public int getItemCount() {
        return orders.size();
    }

    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void setOnItemLongClickListener(View.OnLongClickListener itemLongClickListener) {
        mItemLongClickListener = itemLongClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView countTextView;
        TextView priceTextView;
        TextView deliveryCityTextView;
        TextView deliveryCountryTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.order_name);
            countTextView = itemView.findViewById(R.id.order_count);
            priceTextView = itemView.findViewById(R.id.order_price);
            deliveryCountryTextView = itemView.findViewById(R.id.delivery_country);
            deliveryCityTextView = itemView.findViewById(R.id.delivery_city);
            itemView.setTag(this);
            itemView.setOnClickListener(mItemClickListener);
            itemView.setOnLongClickListener(mItemLongClickListener);
        }
    }
}