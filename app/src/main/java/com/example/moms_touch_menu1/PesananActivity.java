package com.example.moms_touch_menu1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PesananActivity extends AppCompatActivity {
    Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_pesanan);

        Intent intent = getIntent();
        if (intent != null) {
            String foodName = intent.getStringExtra("food_name");
            int foodPrice = intent.getIntExtra("food_price", 0);
            int quantity = intent.getIntExtra("quantity", 0);

            TextView foodNameTextView = findViewById(R.id.textViewFoodName);
            TextView priceTextView = findViewById(R.id.textViewPrice);
            TextView quantityTextView = findViewById(R.id.textViewQuantity);
            TextView totalPriceTextView = findViewById(R.id.textViewTotalPrice); // Find the total price view

            foodNameTextView.setText("Food Name: " + foodName);
            priceTextView.setText("Price: " + getString(R.string.price_format, foodPrice));
            quantityTextView.setText("Quantity: " + quantity);

            int totalPrice = foodPrice * quantity;
            totalPriceTextView.setText("Total " + getString(R.string.price_format, totalPrice));

        }
    }

    public void toMenu(View v){
        it = new Intent(this, RecyclerView.class);
        startActivity(it);
    }
}
