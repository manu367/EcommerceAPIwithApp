package com.example.ecommerceapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerceapp.R;
import com.example.ecommerceapp.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<Category> categories;
    private Context context;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        // "View More" condition
        if (position == 15 && categories.size() > 15) {
            holder.txtCategory.setText("View More");
            holder.imgCategory.setImageResource(R.drawable.more); // fallback local icon
            holder.itemView.setOnClickListener(v -> {
                // open full category page
            });
        } else {
            Category category = categories.get(position);
            holder.txtCategory.setText(category.getName());

            Glide.with(context)
                    .load(category.getImageUrl())
                    .into(holder.imgCategory);
        }
    }


    @Override
    public int getItemCount() {
        // Show max 15 + 1 (View More)
        return Math.min(categories.size(), 15) + (categories.size() > 15 ? 1 : 0);
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCategory;
        TextView txtCategory;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCategory = itemView.findViewById(R.id.imgCategory);
            txtCategory = itemView.findViewById(R.id.txtCategory);
        }
    }
}

