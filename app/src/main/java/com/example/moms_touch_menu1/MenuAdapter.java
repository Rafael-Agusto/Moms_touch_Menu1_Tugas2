package com.example.moms_touch_menu1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private ArrayList<Menu> menuList;
    public OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public MenuAdapter(ArrayList<Menu> menuList) {
        this.menuList = menuList;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new MenuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Menu menu = menuList.get(position);
        holder.menuNameTextView.setText(menu.getName());
        holder.menuDescriptionTextView.setText(menu.getDescription());
        holder.menuPriceTextView.setText(String.valueOf(menu.getPrice()));
        holder.menuImageView.setImageResource(menu.getImageResource());

        // Set click listener for the "Order" button
        holder.buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedPosition = holder.getBindingAdapterPosition(); // Get the adapter position of the clicked item
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(clickedPosition);
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        ImageView menuImageView;
        TextView menuNameTextView;
        TextView menuDescriptionTextView;
        TextView menuPriceTextView;
        Button buttonOrder;  // Add a reference to the "Order" button

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            menuImageView = itemView.findViewById(R.id.imageViewFood);
            menuNameTextView = itemView.findViewById(R.id.textViewName);
            menuDescriptionTextView = itemView.findViewById(R.id.textViewDescription);
            menuPriceTextView = itemView.findViewById(R.id.textViewPrice);
            buttonOrder = itemView.findViewById(R.id.buttonOrder);  // Initialize the "Order" button
        }
    }
}
