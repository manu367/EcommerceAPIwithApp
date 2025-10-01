package com.example.ecommerceapp.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.adapter.ImagePagerAdapter;
import com.example.ecommerceapp.adapter.ReviewAdapter;
import com.example.ecommerceapp.model.Review;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

public class ProductViewActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private WebView webView;
    private RatingBar ratingBar;
    private TextView reviewCount;
    private RecyclerView reviewRecycler;
    private Button btnAddToCart, btnBuyNow;
    private TextView productTitle, productPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_view);

        // Bind views
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabDots);
        webView = findViewById(R.id.webView);
        ratingBar = findViewById(R.id.ratingBar);
        reviewCount = findViewById(R.id.reviewCount);
        reviewRecycler = findViewById(R.id.reviewRecycler);
        btnAddToCart = findViewById(R.id.btnAddToCart);
        btnBuyNow = findViewById(R.id.btnBuyNow);
        productTitle = findViewById(R.id.productTitle);
        productPrice = findViewById(R.id.productPrice);

        List<String> images = Arrays.asList(
                "https://via.placeholder.com/300.png?text=Image1",
                "https://via.placeholder.com/300.png?text=Image2",
                "https://via.placeholder.com/300.png?text=Image3"
        );

        ImagePagerAdapter adapter = new ImagePagerAdapter(images);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
        }).attach();

        // Setup WebView
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData("<h2>Product Details</h2><p>This is an amazing product with great features!</p>",
                "text/html", "utf-8");
        webView.setWebViewClient(new WebViewClient());

        // Setup rating
        ratingBar.setRating(4.5f);
        reviewCount.setText("(120 reviews)");
        // Setup Reviews RecyclerView
        reviewRecycler.setLayoutManager(new LinearLayoutManager(this));
        List<Review> reviews = Arrays.asList(
                new Review("Alice", 5f, "Awesome product!"),
                new Review("Bob", 4f, "Good value for money."),
                new Review("Charlie", 3f, "Average, expected more.")
        );
        ReviewAdapter reviewAdapter = new ReviewAdapter(reviews);
        reviewRecycler.setAdapter(reviewAdapter);

        // Button clicks
        btnAddToCart.setOnClickListener(v -> {
            // Add to cart logic
        });
        btnBuyNow.setOnClickListener(v -> {
            // Buy now logic
        });
    }

}