package com.example.ecommerceapp.fragement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.adapter.CartAdapter;
import com.example.ecommerceapp.model.CartItem;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;


public class CartFragment extends Fragment {

    private RecyclerView recyclerCart;
    private TextView tvSubtotal, tvTax, tvTotal;
    private MaterialButton btnCheckout;
    private CartAdapter cartAdapter;
    private List<CartItem> cartList;
    private View view;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_cart, container, false);
        recyclerCart = view.findViewById(R.id.recycler_cart);
        tvSubtotal = view.findViewById(R.id.tvSubtotal);
        tvTax = view.findViewById(R.id.tvTax);
        tvTotal = view.findViewById(R.id.tvTotal);
        btnCheckout = view.findViewById(R.id.btnCheckout);

        cartList = new ArrayList<>();
        cartList.add(new CartItem("Nike Air Shoes", 1499, 1, R.drawable.ima2));
        cartList.add(new CartItem("Puma T-Shirt", 799, 2, R.drawable.img));
        cartList.add(new CartItem("Puma T-Shirt", 799, 2, R.drawable.img3));
        cartAdapter = new CartAdapter(requireContext(), cartList, new CartAdapter.OnCartChangeListener() {
            @Override
            public void onQuantityChanged() {
                updatePrice();
            }

            @Override
            public void onItemRemoved(int position) {
                updatePrice();
            }
        });
        recyclerCart.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerCart.setAdapter(cartAdapter);

        updatePrice();
        btnCheckout.setOnClickListener(v -> {
            // TODO: handle checkout action
        });


        return view;
    }

    private void updatePrice() {
        int subtotal = 0;
        for (CartItem item : cartAdapter.getCartList()) {
            subtotal += item.getPrice() * item.getQuantity();
        }
        int tax = (int) (subtotal * 0.05); // 5% tax
        int total = subtotal + tax;

        tvSubtotal.setText("₹ " + subtotal);
        tvTax.setText("₹ " + tax);
        tvTotal.setText("₹ " + total);
    }
}