package com.example.ecommerceapp.activity;

import android.os.Bundle;
import android.webkit.JavascriptInterface;
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
    private String html="<!doctype html>\n" +
            "<html lang=\"en\">\n" +
            "\n" +
            "<head>\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n" +
            "    <title>Aurora Pro — Product Details</title>\n" +
            "    <style>\n" +
            "        :root {\n" +
            "            --accent: #ff6b35;\n" +
            "            --blue: #1976d2;\n" +
            "            --muted: #444;\n" +
            "            font-family: -apple-system, BlinkMacSystemFont, \"Segoe UI\", Roboto, Arial;\n" +
            "            color: #000;\n" +
            "        }\n" +
            "\n" +
            "        body {\n" +
            "            margin: 0;\n" +
            "            padding: 0;\n" +
            "            background: #fff;\n" +
            "            -webkit-font-smoothing: antialiased;\n" +
            "        }\n" +
            "\n" +
            "        .wrap {\n" +
            "            width: 100%;\n" +
            "        }\n" +
            "\n" +
            "        .hero {\n" +
            "            padding: 18px;\n" +
            "        }\n" +
            "\n" +
            "        h1.title {\n" +
            "            margin: 0;\n" +
            "            font-size: 24px;\n" +
            "            font-weight: 700;\n" +
            "        }\n" +
            "\n" +
            "        p.sub {\n" +
            "            margin: 6px 0;\n" +
            "            color: var(--muted);\n" +
            "        }\n" +
            "\n" +
            "        .price-row {\n" +
            "            display: flex;\n" +
            "            align-items: center;\n" +
            "            gap: 12px;\n" +
            "            margin: 10px 0;\n" +
            "        }\n" +
            "\n" +
            "        .price {\n" +
            "            font-size: 22px;\n" +
            "            color: var(--accent);\n" +
            "            font-weight: 800;\n" +
            "        }\n" +
            "\n" +
            "        .old {\n" +
            "            font-size: 13px;\n" +
            "            color: var(--muted);\n" +
            "            text-decoration: line-through;\n" +
            "        }\n" +
            "\n" +
            "        .rating {\n" +
            "            background: #f0f7ff;\n" +
            "            color: #0d47a1;\n" +
            "            padding: 6px 8px;\n" +
            "            border-radius: 999px;\n" +
            "            font-weight: 700;\n" +
            "            font-size: 13px;\n" +
            "        }\n" +
            "\n" +
            "        .cta {\n" +
            "            display: flex;\n" +
            "            gap: 10px;\n" +
            "            margin-top: 12px;\n" +
            "            flex-wrap: wrap;\n" +
            "        }\n" +
            "\n" +
            "        .btn {\n" +
            "            padding: 10px 14px;\n" +
            "            border-radius: 8px;\n" +
            "            border: none;\n" +
            "            font-weight: 700;\n" +
            "            cursor: pointer;\n" +
            "            color: #fff;\n" +
            "            background: var(--blue);\n" +
            "        }\n" +
            "\n" +
            "        .section {\n" +
            "            padding: 18px;\n" +
            "            border-top: 1px solid #e5e5e5;\n" +
            "        }\n" +
            "\n" +
            "        .section h3 {\n" +
            "            margin: 0 0 10px 0;\n" +
            "            font-size: 16px;\n" +
            "        }\n" +
            "\n" +
            "        /* Offers */\n" +
            "        .offers {\n" +
            "            display: flex;\n" +
            "            flex-direction: column;\n" +
            "            gap: 8px;\n" +
            "        }\n" +
            "\n" +
            "        .offer {\n" +
            "            background: #f4f8ff;\n" +
            "            border-left: 4px solid var(--blue);\n" +
            "            padding: 10px;\n" +
            "            border-radius: 6px;\n" +
            "            font-size: 14px;\n" +
            "            color: #0d305a;\n" +
            "        }\n" +
            "\n" +
            "        /* Variants (radio) */\n" +
            "        .variants {\n" +
            "            display: flex;\n" +
            "            flex-wrap: wrap;\n" +
            "            gap: 10px;\n" +
            "        }\n" +
            "\n" +
            "        .variant {\n" +
            "            display: flex;\n" +
            "            align-items: center;\n" +
            "            gap: 8px;\n" +
            "            background: #f9f9f9;\n" +
            "            padding: 8px 10px;\n" +
            "            border-radius: 8px;\n" +
            "            border: 1px solid #ddd;\n" +
            "            cursor: pointer;\n" +
            "        }\n" +
            "\n" +
            "        .variant input {\n" +
            "            transform: scale(1.1);\n" +
            "        }\n" +
            "\n" +
            "        /* Long description */\n" +
            "        .longdesc {\n" +
            "            color: var(--muted);\n" +
            "            line-height: 1.6;\n" +
            "            margin-top: 6px;\n" +
            "            font-size: 15px;\n" +
            "        }\n" +
            "\n" +
            "        /* Tables */\n" +
            "        table {\n" +
            "            width: 100%;\n" +
            "            border-collapse: collapse;\n" +
            "            margin-top: 8px;\n" +
            "            font-size: 14px;\n" +
            "        }\n" +
            "\n" +
            "        th,\n" +
            "        td {\n" +
            "            padding: 10px 8px;\n" +
            "            border-bottom: 1px solid #f2f2f2;\n" +
            "            text-align: left;\n" +
            "        }\n" +
            "\n" +
            "        th {\n" +
            "            width: 35%;\n" +
            "            color: var(--muted);\n" +
            "            font-weight: 600;\n" +
            "        }\n" +
            "\n" +
            "        /* Responsive */\n" +
            "        @media (max-width:720px) {\n" +
            "            .hero {\n" +
            "                padding: 12px\n" +
            "            }\n" +
            "        }\n" +
            "    </style>\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            "    <div class=\"wrap\">\n" +
            "        <div class=\"hero\">\n" +
            "            <h1 class=\"title\">Aurora Pro Wireless Headphones</h1>\n" +
            "            <p class=\"sub\">Retro craftsmanship, modern tuning — for long listening sessions and clean focus.</p>\n" +
            "\n" +
            "            <div class=\"price-row\">\n" +
            "                <div class=\"price\" id=\"price\">₹7,999</div>\n" +
            "                <div class=\"old\" id=\"oldPrice\">₹12,499</div>\n" +
            "                <div class=\"rating\">4.6 ★ (2.3k)</div>\n" +
            "            </div>\n" +
            "\n" +
            "            <div class=\"section\" style=\"padding:0;\">\n" +
            "                <h3 style=\"margin:0 0 8px 0;font-size:14px;\">Available offers</h3>\n" +
            "                <div class=\"offers\" id=\"offers\">\n" +
            "                    <div class=\"offer\">Bank Offer: 10% off with XYZ Bank credit cards, up to ₹800.</div>\n" +
            "                    <div class=\"offer\">Exchange Offer: Up to ₹3,000 off on exchange.</div>\n" +
            "                    <div class=\"offer\">No-cost EMI available for 3 & 6 months (T&C apply).</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "\n" +
            "            <div class=\"section\" style=\"padding:10px 0 0 0;\">\n" +
            "                <h3 style=\"margin:0 0 8px 0;font-size:14px;\">Variants</h3>\n" +
            "                <div class=\"variants\" id=\"variants\">\n" +
            "                    <label class=\"variant\"><input type=\"radio\" name=\"variant\" value=\"7999\" checked> Black — ₹7,999</label>\n" +
            "                    <label class=\"variant\"><input type=\"radio\" name=\"variant\" value=\"8499\"> Silver — ₹8,499</label>\n" +
            "                    <label class=\"variant\"><input type=\"radio\" name=\"variant\" value=\"8999\"> Limited Blue — ₹8,999</label>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"section\">\n" +
            "            <h3>Long description</h3>\n" +
            "            <div class=\"longdesc\">\n" +
            "                The Aurora Pro is not just another pair of headphones — it is a manifesto for sound lovers. With balanced\n" +
            "                mids, rich bass, sculpted highs and premium build, it’s made to last decades. Memory-foam cushions,\n" +
            "                aluminum hinges, and all-day battery ensure both comfort and endurance.\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"section\">\n" +
            "            <h3>Features</h3>\n" +
            "            <table>\n" +
            "                <tbody>\n" +
            "                    <tr>\n" +
            "                        <th>Battery Life</th>\n" +
            "                        <td>40 hrs (ANC off) · 30 hrs (ANC on)</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <th>Noise Control</th>\n" +
            "                        <td>Active Noise Cancellation + Ambient Mode</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <th>Quick Charge</th>\n" +
            "                        <td>10 min → 4 hrs playback</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <th>Audio Codec</th>\n" +
            "                        <td>aptX Adaptive, LDAC</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <th>Build</th>\n" +
            "                        <td>Aircraft aluminum · vegan leather</td>\n" +
            "                    </tr>\n" +
            "                </tbody>\n" +
            "            </table>\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"section\">\n" +
            "            <h3>Specifications</h3>\n" +
            "            <table>\n" +
            "                <tbody>\n" +
            "                    <tr>\n" +
            "                        <th>Driver</th>\n" +
            "                        <td>40 mm Dynamic</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <th>Connectivity</th>\n" +
            "                        <td>Bluetooth 5.3, Multipoint pairing</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <th>Charging Port</th>\n" +
            "                        <td>USB-C Fast Charge</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <th>Weight</th>\n" +
            "                        <td>240 g</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <th>Warranty</th>\n" +
            "                        <td>1 year</td>\n" +
            "                    </tr>\n" +
            "                </tbody>\n" +
            "            </table>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</body>\n" +
            "\n" +
            "</html>\n";
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
                "https://rukminim2.flixcart.com/fk-p-flap/1040/560/image/f6af21bc5209c658.jpg",
                "https://rukminim2.flixcart.com/fk-p-flap/1040/560/image/f6af21bc5209c658.jpg",
                "https://rukminim2.flixcart.com/fk-p-flap/1040/560/image/f6af21bc5209c658.jpg"
        );

        ImagePagerAdapter adapter = new ImagePagerAdapter(images,this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
        }).attach();

        // Setup WebView
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true); // safer for modern pages
        webView.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);
        webView.setWebViewClient(new WebViewClient());
        webView.addJavascriptInterface(new Object() {
            @JavascriptInterface
            public void onBuy() {
                runOnUiThread(() -> {
                    // navigate to checkout
                });
            }
            @JavascriptInterface
            public void onAddToCart() {
                runOnUiThread(() -> {
                    // add current variant to cart
                });
            }
        }, "Android");

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