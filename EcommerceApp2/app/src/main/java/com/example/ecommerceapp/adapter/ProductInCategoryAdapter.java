package com.example.ecommerceapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerceapp.R;
import com.example.ecommerceapp.activity.OnProductClickListener;
import com.example.ecommerceapp.activity.ProductViewActivity;
import com.example.ecommerceapp.model.Product;

import java.util.List;

public class ProductInCategoryAdapter extends RecyclerView.Adapter<ProductInCategoryAdapter.ProductInCategoryAdapterViewHolder> {
    List<Product> productList;
    Context context;
    OnProductClickListener listener;
    public ProductInCategoryAdapter(List<Product> productList, Context context,OnProductClickListener listener){
        this.productList=productList;
        this.context=context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductInCategoryAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductInCategoryAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductInCategoryAdapterViewHolder holder, int position) {
        Product product=productList.get(position);
        holder.tvProductTitle.setText(product.getProducttitle());
        Glide.with(context)
                .load(product.getImageURL())
                .into(holder.imgProduct);

        holder.productContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onProductClick(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductInCategoryAdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgProduct;
        private TextView tvProductTitle;
        private CardView productContainer;

        public ProductInCategoryAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct=itemView.findViewById(R.id.imgProduct);
            tvProductTitle=itemView.findViewById(R.id.tvProductTitle);
            productContainer=itemView.findViewById(R.id.productContainer);
        }
    }
}
