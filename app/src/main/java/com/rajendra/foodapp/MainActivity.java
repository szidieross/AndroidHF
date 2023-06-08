package com.rajendra.foodapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rajendra.foodapp.adapter.AsiaFoodAdapter;
import com.rajendra.foodapp.model.AsiaFood;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AsiaFoodAdapter.OnItemClickListener {

    RecyclerView popularRecycler, asiaRecycler;
    AsiaFoodAdapter asiaFoodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<AsiaFood> asiaFoodList = new ArrayList<>();
        asiaFoodList.add(new AsiaFood("Exotic Pizza", "$20", R.drawable.p1, "4.8", "Briand Restaurant"));
        asiaFoodList.add(new AsiaFood("Cheese Pizza", "$25", R.drawable.p2, "4.1", "Friends Restaurant"));
        asiaFoodList.add(new AsiaFood("Salami Pizza", "$20", R.drawable.p3, "4.5", "Briand Restaurant"));
        asiaFoodList.add(new AsiaFood("Chicago Pizza", "$25", R.drawable.p4, "4.2", "Friends Restaurant"));
        asiaFoodList.add(new AsiaFood("Prosciutto Pizza", "$20", R.drawable.p5, "4.5", "Briand Restaurant"));
        asiaFoodList.add(new AsiaFood("Truffle Pizza", "$25", R.drawable.p6, "4.2", "Friends Restaurant"));
        asiaFoodList.add(new AsiaFood("New York Pizza", "$25", R.drawable.p7, "4.1", "Friends Restaurant"));
        asiaFoodList.add(new AsiaFood("Chicago Pizza", "$20", R.drawable.p8, "4.5", "Briand Restaurant"));
        asiaFoodList.add(new AsiaFood("Mini Pizza", "$25", R.drawable.p9, "4.2", "Friends Restaurant"));
        asiaFoodList.add(new AsiaFood("Chicago Pizza", "$20", R.drawable.p10, "4.5", "Briand Restaurant"));

        setAsiaRecycler(asiaFoodList);
    }

    private void setAsiaRecycler(List<AsiaFood> asiaFoodList) {
        asiaRecycler = findViewById(R.id.asia_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        asiaRecycler.setLayoutManager(layoutManager);
        asiaFoodAdapter = new AsiaFoodAdapter(this, asiaFoodList);
        asiaFoodAdapter.setOnItemClickListener(this);
        asiaRecycler.setAdapter(asiaFoodAdapter);
    }

    @Override
    public void onItemClick(AsiaFood item) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("name", item.getName());
        intent.putExtra("price", item.getPrice());
        intent.putExtra("image", item.getImageUrl());
        startActivity(intent);
    }
}
