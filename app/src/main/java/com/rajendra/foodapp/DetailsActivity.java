package com.rajendra.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import com.rajendra.foodapp.CartManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    private Button buttonGoBack;
    private Button minus;
    private Button plus;
    private TextView textName, textPrice,amount;
    private ImageView foodImage;
    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textName = findViewById(R.id.textName);
        textPrice = findViewById(R.id.textPrice);
        foodImage = findViewById(R.id.foodImage);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        amount = findViewById(R.id.amount);
        buttonGoBack = findViewById(R.id.buttonGoBack);
        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainActivity();
            }
        });

        Button buttonAddToCart = findViewById(R.id.button);
        buttonAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart();
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseAmount();
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseAmount();
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String price = intent.getStringExtra("price");
            int imageResId = intent.getIntExtra("image", 0);
            if (name != null && price != null) {
                textName.setText(name);
                textPrice.setText(price);
                foodImage.setImageResource(imageResId);
            }
        }
    }


    private void navigateToMainActivity() {
        Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void addToCart1() {
        Toast.makeText(this, "Item added to cart", Toast.LENGTH_SHORT).show();
    }

    private void addToCart() {
        String itemName = textName.getText().toString();
        String itemPrice = textPrice.getText().toString();
        int itemQuantity = quantity;

        // Add multiple cart items based on the itemQuantity value
        for (int i = 0; i < itemQuantity; i++) {
            // Create a CartItem object with the item details
            CartItem cartItem = new CartItem(itemName, itemPrice, 1); // Each item has a quantity of 1

            // Add the cart item to the cart
            CartManager.getInstance().addToCart(cartItem);
        }

        // Get the count of items in the cartItems list
        int itemCount = CartManager.getInstance().getCartItems().size();

        // Show a toast message indicating the item was added to the cart and the total item count
        String message = "Items added to cart: " + itemQuantity + ". Total items: " + itemCount;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }




    private void increaseAmount() {
        quantity++;
        amount.setText(String.valueOf(quantity));
    }

    private void decreaseAmount() {
        if (quantity > 1) {
            quantity--;
            amount.setText(String.valueOf(quantity));
        }
    }
}
