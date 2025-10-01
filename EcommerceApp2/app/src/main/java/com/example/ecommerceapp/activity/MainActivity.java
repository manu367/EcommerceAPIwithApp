package com.example.ecommerceapp.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import com.example.ecommerceapp.R;

import com.example.ecommerceapp.fragement.CartFragment;
import com.example.ecommerceapp.fragement.CategoryFragment;
import com.example.ecommerceapp.fragement.HomeFragment;
import com.example.ecommerceapp.fragement.ProfileFragment;
import com.example.ecommerceapp.fragement.ReelFragment;
import com.example.ecommerceapp.model.User;
import com.example.ecommerceapp.viewmodel.UserViewModel;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
//    private ActivityMainBinding binding;
    private UserViewModel userViewModel;
    private BottomNavigationView bottomNavigationView;
    public MainActivity(){
        Log.d("manupathak","Constructor running");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("manupathak","hello how are you");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottom_navigation);


        var badge =bottomNavigationView.getOrCreateBadge(R.id.cart);
        badge.setNumber(1);
        badge.setVisible(badge.getNumber()>0);

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        }



        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = new HomeFragment();
//                Toast.makeText(MainActivity.this, "Manu"+menuItem.getItemId(), Toast.LENGTH_SHORT).show();
//
//                Log.d("MENUID=",menuItem.getItemId()+"");
//                Log.d("Menuid=",R.menu.bottom_nav_menu+"");
                switch(menuItem.getItemId()){
                    case R.id.navhomemenu:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.nav_reel:
                        selectedFragment = new ReelFragment();
                        break;
                    case R.id.nav_category:
                        selectedFragment = new CategoryFragment();
                        break;
                    case R.id.nav_profile:
                        selectedFragment = new ProfileFragment();
                        break;
                    case R.id.cart:
                        selectedFragment = new CartFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
                return true;
            }
        });

    }
}