package com.example.ecommerceapp.repositery;

import androidx.lifecycle.MutableLiveData;

import com.example.ecommerceapp.model.User;

public class UserRepository {

    private MutableLiveData<User> userData = new MutableLiveData<>();

    public MutableLiveData<User> getUserData(){
        return userData;
    }

    public void fetchUser(){
        // Simulate fetching data (from API/DB)
        User user = new User("Manu", 25);
        userData.setValue(user);
    }
}
