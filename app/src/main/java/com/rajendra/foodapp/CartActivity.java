package com.rajendra.foodapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
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
    private double totalPrice = 0.0;
    private int totalAmount = 0;
    private String price = "";

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

        List<CartItem> cartItems = CartManager.getInstance().getCartItems();

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

            totalAmount += 1;
            price = itemPrice.substring(1);
            totalPrice += Double.parseDouble(price);

            TextView itemNameTextView = new TextView(this);
            itemNameTextView.setText(itemName + ": " + itemPrice);
            itemNameTextView.setTextColor(getResources().getColor(R.color.colorText));
            itemNameTextView.setTextSize(18);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                itemNameTextView.setTypeface(Typeface.create(getResources().getFont(R.font.semibold), Typeface.BOLD));
            }
            cartItemsLayout.addView(itemNameTextView);
        }

        TextView totalAmountTextView = new TextView(this);
        totalAmountTextView.setText("Pizza Amount: " + totalAmount);
        totalAmountTextView.setTextColor(getResources().getColor(R.color.colorText));
        totalAmountTextView.setPadding(0, 24, 0, 0);
        totalAmountTextView.setTextSize(24);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            totalAmountTextView.setTypeface(Typeface.create(getResources().getFont(R.font.semibold), Typeface.BOLD));
        }
        cartItemsLayout.addView(totalAmountTextView);

        TextView totalPriceTextView = new TextView(this);
        totalPriceTextView.setText("Total Price: $" + String.format("%.2f", totalPrice));
        totalPriceTextView.setTextColor(getResources().getColor(R.color.colorText));
        totalPriceTextView.setPadding(0, 24, 0, 0);
        totalPriceTextView.setTextSize(24);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            totalPriceTextView.setTypeface(Typeface.create(getResources().getFont(R.font.semibold), Typeface.BOLD));
        }
        cartItemsLayout.addView(totalPriceTextView);
    }
}
