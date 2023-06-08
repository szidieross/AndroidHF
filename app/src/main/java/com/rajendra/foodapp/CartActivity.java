package com.rajendra.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    private Button buttonGoBack, buttonOrder;
    private LinearLayout cartItemsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        buttonGoBack = findViewById(R.id.buttonGoBack);
        buttonOrder = findViewById(R.id.buttonOrder);
        cartItemsLayout = findViewById(R.id.cartItemsLayout);

        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainActivity();
            }
        });

        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeOrder();
            }
        });

        // Get the list of cart items from the CartManager
        List<CartItem> cartItems = CartManager.getInstance().getCartItems();

        // Display the cart items in the cartItemsLayout
        displayCartItems(cartItems);
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(CartActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void placeOrder() {
        String message = "Your order has been placed!";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void displayCartItems(List<CartItem> cartItems) {
        for (CartItem cartItem : cartItems) {
            String itemName = cartItem.getItemName();
            String itemPrice = cartItem.getItemPrice();

            // Create TextViews for item name and price
            TextView itemNameTextView = new TextView(this);
            itemNameTextView.setText(itemName);
            itemNameTextView.setTextColor(getResources().getColor(R.color.colorText));
            itemNameTextView.setTextSize(18);

            TextView itemPriceTextView = new TextView(this);
            itemPriceTextView.setText(itemPrice);
            itemPriceTextView.setTextColor(getResources().getColor(R.color.colorText));
            itemPriceTextView.setTextSize(18);

            // Add TextViews to the cartItemsLayout
            cartItemsLayout.addView(itemNameTextView);
            cartItemsLayout.addView(itemPriceTextView);
        }
    }
}
