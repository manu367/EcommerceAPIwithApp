package com.example.ecommerceapp.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.adapter.SearchHistoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private EditText etSearch;
    private RecyclerView rvSearchHistory;
    private SearchHistoryAdapter adapter;
    private List<String> searchHistory = new ArrayList<>();
    private List<String> filteredHistory = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);
        etSearch = findViewById(R.id.etSearch);
        rvSearchHistory = findViewById(R.id.rvSearchHistory);

        searchHistory.add("Shoes");
        searchHistory.add("T-Shirt");
        searchHistory.add("Jeans");
        searchHistory.add("Smartphone");
        searchHistory.add("Headphones");

        filteredHistory.addAll(searchHistory);

        adapter = new SearchHistoryAdapter(filteredHistory, new SearchHistoryAdapter.OnItemClickListener() {
            @Override
            public void onItemRemove(String item) {
                searchHistory.remove(item);
                filteredHistory.remove(item);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onItemClick(String item) {
                etSearch.setText(item);
                etSearch.setSelection(item.length());
            }
        });
        rvSearchHistory.setLayoutManager(new LinearLayoutManager(this));
        rvSearchHistory.setAdapter(adapter);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                filterSearch(s.toString());
            }
        });
    }

    private void filterSearch(String query) {
        filteredHistory.clear();
        if (query.isEmpty()) {
            filteredHistory.addAll(searchHistory);
        } else {
            for (String item : searchHistory) {
                if (item.toLowerCase().contains(query.toLowerCase())) {
                    filteredHistory.add(item);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }
}