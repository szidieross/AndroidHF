package com.rajendra.foodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajendra.foodapp.R;
import com.rajendra.foodapp.model.Pizza;

import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.AsiaFoodViewHolder> {

    private Context context;
    private List<Pizza> pizzaList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Pizza item);
    }

    public PizzaAdapter(Context context, List<Pizza> pizzaList) {
        this.context = context;
        this.pizzaList = pizzaList;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public AsiaFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.asia_food_row_item, parent, false);
        return new AsiaFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AsiaFoodViewHolder holder, int position) {
        final Pizza item = pizzaList.get(position);

        holder.foodImage.setImageResource(item.getImageUrl());
        holder.name.setText(item.getName());
        holder.price.setText(item.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    public static class AsiaFoodViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImage;
        TextView price, name, rating, restaurantName;

        public AsiaFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage = itemView.findViewById(R.id.food_image);
            price = itemView.findViewById(R.id.price);
            name = itemView.findViewById(R.id.name);
        }
    }
}
