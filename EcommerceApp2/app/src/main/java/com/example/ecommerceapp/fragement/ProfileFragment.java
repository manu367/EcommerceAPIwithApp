package com.example.ecommerceapp.fragement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.ecommerceapp.R;


public class ProfileFragment extends Fragment {

    private LinearLayout rowOrders, rowWishlist, rowAddress, rowPayment,
            rowNotifications, rowRefer, rowHelp, rowSettings, rowAbout, rowLogout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        // Initialize all rows
                rowOrders = view.findViewById(R.id.rowOrders);
        rowWishlist = view.findViewById(R.id.rowWishlist);
        rowAddress = view.findViewById(R.id.rowAddress);
        rowPayment = view.findViewById(R.id.rowPayment);
        rowNotifications = view.findViewById(R.id.rowNotifications);
        rowRefer = view.findViewById(R.id.rowRefer);
        rowHelp = view.findViewById(R.id.rowHelp);
        rowSettings = view.findViewById(R.id.rowSettings);
        rowAbout = view.findViewById(R.id.rowAbout);
        rowLogout = view.findViewById(R.id.rowLogout);

        // Apply ripple + scale animation on all rows
        applyClickAnimation(rowOrders);
        applyClickAnimation(rowWishlist);
        applyClickAnimation(rowAddress);
        applyClickAnimation(rowPayment);
        applyClickAnimation(rowNotifications);
        applyClickAnimation(rowRefer);
        applyClickAnimation(rowHelp);
        applyClickAnimation(rowSettings);
        applyClickAnimation(rowAbout);
        applyClickAnimation(rowLogout);

        rowOrders.setOnClickListener(v -> {
            // TODO: Open Orders Fragment or Activity
        });

        rowLogout.setOnClickListener(v -> {
            // TODO: Handle logout
        });

        return view;
    }

    private void applyClickAnimation(View v) {
        v.setOnTouchListener((view, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.scale_down));
            } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.scale_up));
            }
            return false; // allow click event to propagate
        });
    }
}