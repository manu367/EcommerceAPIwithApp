package com.example.ecommerceapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.activity.OnProductClickListener;
import com.example.ecommerceapp.model.CategoryWIseProduct;

import java.util.List;

public class CategoryWiseProductAdapter extends RecyclerView.Adapter<CategoryWiseProductAdapter.CategoryWiseProductViewHolder>{

    private List<CategoryWIseProduct> categoryWIseProductList;
    OnProductClickListener listener;
    Context context;
    public  CategoryWiseProductAdapter(List<CategoryWIseProduct> categoryWIseProductList, Context context,OnProductClickListener listener){
        this.categoryWIseProductList=categoryWIseProductList;
        this.context=context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public CategoryWiseProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category_products, parent, false);
        return new CategoryWiseProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryWiseProductViewHolder holder, int position) {
        CategoryWIseProduct categoryWIseProduct=categoryWIseProductList.get(position);
        holder.categoryTitle.setText(categoryWIseProduct.getCategoryTitle());

        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false){
            @Override
            public boolean canScrollVertically() {
                return false; // prevent RecyclerView vertical scroll, let NestedScrollView handle it
            }
        };

        holder.recyclerView.setLayoutManager(layoutManager);
        ProductInCategoryAdapter productInCategoryAdapter=new ProductInCategoryAdapter(categoryWIseProduct.getProductList(),context,this.listener);
        holder.recyclerView.setAdapter(productInCategoryAdapter);
        // yha child ke liye setup hoga;
    }

    @Override
    public int getItemCount() {
        return categoryWIseProductList.size();
    }

    public static class CategoryWiseProductViewHolder extends RecyclerView.ViewHolder {
        TextView categoryTitle;
        RecyclerView recyclerView;

        public CategoryWiseProductViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTitle=itemView.findViewById(R.id.tvCategoryTitle);
            recyclerView=itemView.findViewById(R.id.rvProducts);
        }
    }
}
