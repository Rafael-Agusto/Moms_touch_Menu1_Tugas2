package com.example.moms_touch_menu1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class FoodOrderActivity extends AppCompatActivity {

    private int quantity = 1; // Initial quantity
    private int foodPrice;
    private String foodName;
    private TextView quantityTextView;
    private TextView totalPriceTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            foodName = extras.getString("food_name");
            String foodDescription = extras.getString("food_description");
            foodPrice = extras.getInt("food_price");
            int foodImageResId = extras.getInt("food_image");

            // Populate the views with data
            ImageView imageView = findViewById(R.id.imageViewFoodOrder);
            TextView nameTextView = findViewById(R.id.textViewNameOrder);
            TextView descriptionTextView = findViewById(R.id.textViewDescriptionOrder);
            TextView priceTextView = findViewById(R.id.textViewPriceOrder);
            quantityTextView = findViewById(R.id.textViewQuantity);
            totalPriceTextView = findViewById(R.id.textViewTotalPrice);

            imageView.setImageResource(foodImageResId);
            nameTextView.setText(foodName);
            descriptionTextView.setText(foodDescription);
            priceTextView.setText(getString(R.string.price_format, foodPrice));

            Button addButton = findViewById(R.id.buttonAdd);
            addButton.setOnClickListener(v -> {
                quantity++;
                updateQuantityAndTotalPrice();
            });

            Button subtractButton = findViewById(R.id.buttonSubtract);
            subtractButton.setOnClickListener(v -> {
                if (quantity > 1) {
                    quantity--;
                    updateQuantityAndTotalPrice();
                }
            });

            Button beliButton = findViewById(R.id.beli);
            beliButton.setOnClickListener(v -> {
                toPesanan();
            });

            updateQuantityAndTotalPrice();
        }
    }

    private void updateQuantityAndTotalPrice() {
        quantityTextView.setText(String.valueOf(quantity));
        int total = foodPrice * quantity;
        totalPriceTextView.setText(getString(R.string.price_format, total));
    }

    public void toPesanan() {
        Intent pesananIntent = new Intent(this, PesananActivity.class);
        pesananIntent.putExtra("food_name", foodName);
        pesananIntent.putExtra("food_price", foodPrice);
        pesananIntent.putExtra("quantity", quantity); // Use the actual quantity value
        startActivity(pesananIntent);
    }
}
