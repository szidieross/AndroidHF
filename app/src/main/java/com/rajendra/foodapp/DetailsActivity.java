package com.rajendra.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    private Button buttonGoBack;
    private TextView textName, textPrice;
    private ImageView foodImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textName = findViewById(R.id.textName);
        textPrice = findViewById(R.id.textPrice);
        foodImage = findViewById(R.id.foodImage);
        buttonGoBack = findViewById(R.id.buttonGoBack);
        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainActivity();
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
}
