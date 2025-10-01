package com.example.ecommerceapp.fragement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.activity.OnProductClickListener;
import com.example.ecommerceapp.activity.ProductViewActivity;
import com.example.ecommerceapp.activity.SearchActivity;
import com.example.ecommerceapp.adapter.BannerAdapter;
import com.example.ecommerceapp.adapter.CategoryAdapter;
import com.example.ecommerceapp.adapter.CategoryWiseProductAdapter;
import com.example.ecommerceapp.model.Category;
import com.example.ecommerceapp.model.CategoryWIseProduct;
import com.example.ecommerceapp.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeFragment extends Fragment {

    private ViewPager2 viewPager2;
    private Handler handler;
    private Runnable runnable;
    private RecyclerView recyclerCategories,categoryShow;

    public HomeFragment() {} // Default constructor only

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager2 = view.findViewById(R.id.bannerViewPager);
        recyclerCategories=view.findViewById(R.id.recyclerCategories);
        categoryShow=view.findViewById(R.id.categoryShow);
        LinearLayout linearLayout=view.findViewById(R.id.search_bar_click);

        view.findViewById(R.id.search_edit_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
                requireActivity().overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
                requireActivity().overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
            }
        });

        recyclerCategories.setNestedScrollingEnabled(false);

        viewPager(viewPager2);
        createCategory(recyclerCategories);
        createCategoryByShowProduct(categoryShow);


        return view;
    }

    private void createCategory(RecyclerView recyclerCategories){
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("mobiles", "https://rukminim2.flixcart.com/fk-p-flap/128/128/image/cd6aca4f61e8ea95.png"));
        categoryList.add(new Category("Tv & Appliances", "https://rukminim2.flixcart.com/fk-p-flap/128/128/image/9c64dfa667885ca9.png"));
        categoryList.add(new Category("Electronics", "https://rukminim2.flixcart.com/fk-p-flap/128/128/image/4d6b13d5a0e0724a.png"));
        categoryList.add(new Category("Fashion", "https://rukminim2.flixcart.com/fk-p-flap/128/128/image/ec2982e5564fe07c.png?q=100"));
        categoryList.add(new Category("Home & Kitchen", "https://rukminim2.flixcart.com/fk-p-flap/128/128/image/febcb9896245caf4.png"));
        categoryList.add(new Category("Beauty & toy", "https://rukminim2.flixcart.com/fk-p-flap/128/128/image/3d7144345bbcf2e4.png"));
        categoryList.add(new Category("Furniture", "https://rukminim2.flixcart.com/fk-p-flap/128/128/image/cddd92e134ba3ea9.png"));
        categoryList.add(new Category("grocery", "https://rukminim2.flixcart.com/fk-p-flap/128/128/image/2ebb95ec20eae8f1.png"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false){
            @Override
            public boolean canScrollVertically() {
                return false; // prevent RecyclerView vertical scroll, let NestedScrollView handle it
            }
        };
        recyclerCategories.setLayoutManager(layoutManager);
        CategoryAdapter categoryAdapter=new CategoryAdapter(requireContext(),categoryList);
        recyclerCategories.setAdapter(categoryAdapter);
    }
    private void viewPager(ViewPager2 viewPager2){
        List<Integer> banners = Arrays.asList(R.drawable.img, R.drawable.ima2, R.drawable.img3);

        // Use requireContext() here — never null
        BannerAdapter adapter = new BannerAdapter(requireContext(), banners);
        viewPager2.setAdapter(adapter);

        // Optional page animation
        viewPager2.setPageTransformer((page, position) -> {
            page.setScaleY(0.85f + (1 - Math.abs(position)) * 0.15f);
            page.setAlpha(0.5f + (1 - Math.abs(position)) * 0.5f);
        });

        // Auto-scroll
        handler = new Handler();
        runnable = new Runnable() {
            int currentItem = 0;
            @Override
            public void run() {
                if (currentItem == banners.size()) currentItem = 0;
                viewPager2.setCurrentItem(currentItem++, true);
                handler.postDelayed(this, 3000);
            }
        };
        handler.postDelayed(runnable, 3000);

    }

    private void createCategoryByShowProduct(RecyclerView recyclerCategories){
        List<CategoryWIseProduct> categoryList = addCategory();
        CategoryWiseProductAdapter adapter=new CategoryWiseProductAdapter(categoryList, requireContext(), new OnProductClickListener() {
            @Override
            public void onProductClick(Product product) {
                productViewactivity();
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false){
            @Override
            public boolean canScrollVertically() {
                return false; // prevent RecyclerView vertical scroll, let NestedScrollView handle it
            }
        };
        recyclerCategories.setLayoutManager(layoutManager);
        recyclerCategories.setAdapter(adapter);
    }

    private List<CategoryWIseProduct> addCategory(){
        List<CategoryWIseProduct> categoryWIseProducts=new ArrayList<>();

        List<Product> productList=new ArrayList<>();
        productList.add(new Product(1,"Google Pixel 9","https://rukminim2.flixcart.com/image/240/240/xif0q/mobile/q/l/i/-original-imahegqhjqz38uks.jpeg"));
        productList.add(new Product(2,"Iphone 9","https://rukminim2.flixcart.com/image/240/240/xif0q/mobile/f/a/6/-original-imahfz2tnafhmagr.jpeg"));
        productList.add(new Product(3,"Samsung S24","https://rukminim2.flixcart.com/image/240/240/xif0q/mobile/o/j/d/-original-imahgy25zuwqzzye.jpeg"));
        productList.add(new Product(4,"MotoRola","https://rukminim2.flixcart.com/image/240/240/xif0q/mobile/y/w/k/-original-imahfvpcn3j8qwzk.jpeg"));
        productList.add(new Product(5,"Oopo","https://rukminim2.flixcart.com/image/240/240/xif0q/mobile/h/q/k/-original-imahfw4vamrf5xhf.jpeg"));
        productList.add(new Product(6,"Vivo","https://rukminim2.flixcart.com/image/240/240/xif0q/mobile/2/3/i/-original-imahfkvffkd4qhma.jpeg"));
        categoryWIseProducts.add(new CategoryWIseProduct(1,"Trending Product",productList));

        List<Product> productListFeatures=new ArrayList<>();
        productListFeatures.add(new Product(1,"65 inch TV","https://rukminim2.flixcart.com/image/240/240/xif0q/television/n/j/0/-original-imahcsfhhbnpzt5z.jpeg"));
        productListFeatures.add(new Product(2,"LG Morala","https://rukminim2.flixcart.com/image/312/312/xif0q/air-conditioner-new/k/6/k/-original-imah4gsyqzwzzhhx.jpeg"));
        productListFeatures.add(new Product(3,"skb kjsjbc ","https://rukminim2.flixcart.com/image/312/312/xif0q/air-conditioner-new/k/6/k/-original-imah4gsyqzwzzhhx.jpeg"));
        productListFeatures.add(new Product(4,"kejh lweh","https://rukminim2.flixcart.com/image/312/312/xif0q/air-conditioner-new/k/6/k/-original-imah4gsyqzwzzhhx.jpeg"));
        productListFeatures.add(new Product(5,"kjd kwehk","https://rukminim2.flixcart.com/image/312/312/xif0q/air-conditioner-new/k/6/k/-original-imah4gsyqzwzzhhx.jpeg"));
        categoryWIseProducts.add(new CategoryWIseProduct(1,"Features Product",productListFeatures));

//        List<Product> productElectronices=new ArrayList<>();
//        productElectronices.add(new Product(1,"",""));
//        productElectronices.add(new Product(2,"",""));
//        productElectronices.add(new Product(3,"",""));
//        productElectronices.add(new Product(4,"",""));
//        productElectronices.add(new Product(5,"",""));
//        categoryWIseProducts.add(new CategoryWIseProduct(1,"Electronices Product",productElectronices));

        return categoryWIseProducts;
    }


    private void productViewactivity(){
        Intent intent = new Intent(getContext(), ProductViewActivity.class);
        startActivity(intent);
        requireActivity().overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
