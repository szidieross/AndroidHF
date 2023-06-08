package com.rajendra.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rajendra.foodapp.adapter.PizzaAdapter;
import com.rajendra.foodapp.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PizzaAdapter.OnItemClickListener {

    RecyclerView popularRecycler, asiaRecycler;
    PizzaAdapter pizzaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Pizza> pizzaList = new ArrayList<>();
        pizzaList.add(new Pizza("Exotic Pizza", "$20", R.drawable.p1, "4.8", "Briand Restaurant"));
        pizzaList.add(new Pizza("Cheese Pizza", "$25", R.drawable.p2, "4.1", "Friends Restaurant"));
        pizzaList.add(new Pizza("Salami Pizza", "$20", R.drawable.p3, "4.5", "Briand Restaurant"));
        pizzaList.add(new Pizza("Chicago Pizza", "$25", R.drawable.p4, "4.2", "Friends Restaurant"));
        pizzaList.add(new Pizza("Prosciutto Pizza", "$20", R.drawable.p5, "4.5", "Briand Restaurant"));
        pizzaList.add(new Pizza("Truffle Pizza", "$25", R.drawable.p6, "4.2", "Friends Restaurant"));
        pizzaList.add(new Pizza("New York Pizza", "$25", R.drawable.p7, "4.1", "Friends Restaurant"));
        pizzaList.add(new Pizza("Chicago Pizza", "$20", R.drawable.p8, "4.5", "Briand Restaurant"));
        pizzaList.add(new Pizza("Mini Pizza", "$25", R.drawable.p9, "4.2", "Friends Restaurant"));
        pizzaList.add(new Pizza("Chicago Pizza", "$20", R.drawable.p10, "4.5", "Briand Restaurant"));

        setAsiaRecycler(pizzaList);

        ImageView cartImage = findViewById(R.id.cartImage);
        cartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);

//                Toast.makeText(MainActivity.this, "Navigating to cart", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void setAsiaRecycler(List<Pizza> pizzaList) {
        asiaRecycler = findViewById(R.id.asia_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        asiaRecycler.setLayoutManager(layoutManager);
        pizzaAdapter = new PizzaAdapter(this, pizzaList);
        pizzaAdapter.setOnItemClickListener(this);
        asiaRecycler.setAdapter(pizzaAdapter);
    }

    @Override
    public void onItemClick(Pizza item) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("name", item.getName());
        intent.putExtra("price", item.getPrice());
        intent.putExtra("image", item.getImageUrl());
        startActivity(intent);
    }


}
