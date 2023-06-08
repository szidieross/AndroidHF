package com.rajendra.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {
    private Button buttonGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        buttonGoBack = findViewById(R.id.buttonGoBack);

        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainActivity();
            }
        });
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(CartActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
