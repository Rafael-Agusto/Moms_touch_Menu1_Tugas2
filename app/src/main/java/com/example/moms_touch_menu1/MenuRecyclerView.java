package com.example.moms_touch_menu1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.moms_touch_menu1.MenuAdapter.OnItemClickListener;
public class MenuRecyclerView extends AppCompatActivity implements MenuAdapter.OnItemClickListener{

    RecyclerView recMenu;
    ArrayList<Menu> listMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        recMenu = findViewById(R.id.recMenu);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recMenu.setLayoutManager(layoutManager);

        generateMenu();

        MenuAdapter menuAdapter = new MenuAdapter(listMenu);
        menuAdapter.setOnItemClickListener(this); // Set the click listener
        recMenu.setAdapter(menuAdapter);
    }

    private void generateMenu() {
        listMenu = new ArrayList<>();
        listMenu.add(new Menu("Pastel Tutup", 150000, "So-on dicampur dengan wortel, daging, jamur, lalu ditutup dengan mashed potato", R.drawable.pastel, 0));
        listMenu.add(new Menu("Macaroni Schotel", 150000, "Macaroni dimasak dengan susu dan keju, lalu dicampur dengan wortel, daging, dan sosis", R.drawable.macaroni, 0));
        listMenu.add(new Menu("Mie Frozen", 25000, "Mie ayam kecap dengan pangsit dan baksi frozen, yang dapat di masak sendiri dengan mudah", R.drawable.mie, 0));
        listMenu.add(new Menu("Misoa", 12000, "Misoa yang lembut dengan toping ayam, telur, dan ditaburi dengan daun bawang serta brambang goreng", R.drawable.misoa, 0));
        listMenu.add(new Menu("Asinan Bogor", 15000, "Berbagai macam sayur dan buah direndam dalam kuah dengan cita rasa manis, asam, yang disajikan bersama krupuk dan kacang.", R.drawable.asinan, 0));
        listMenu.add(new Menu("Mie Frozen", 25000, "Mie ayam kecap dengan pangsit dan baksi frozen, yang dapat di masak sendiri dengan mudah", R.drawable.mie, 0));
    }

    public void onItemClick(int position) {
        toOrder(position);
    }

    public void toOrder(int position) {
        Menu selectedItem = listMenu.get(position);
        Intent intent = new Intent(this, FoodOrderActivity.class);
        intent.putExtra("food_name", selectedItem.getName());
        intent.putExtra("food_description", selectedItem.getDescription());
        intent.putExtra("food_price", selectedItem.getPrice());
        intent.putExtra("food_image", selectedItem.getImageResource());
        startActivity(intent);
    }


}
