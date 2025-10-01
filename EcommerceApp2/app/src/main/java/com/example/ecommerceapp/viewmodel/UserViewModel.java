package com.example.ecommerceapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ecommerceapp.model.User;
import com.example.ecommerceapp.repositery.UserRepository;

public class UserViewModel extends ViewModel {

    private UserRepository userRepository;
    private LiveData<User> user;

    public UserViewModel(){
        userRepository = new UserRepository();
        user = userRepository.getUserData();
    }

    public LiveData<User> getUser(){
        return user;
    }

    public void fetchUser(){
        userRepository.fetchUser();
    }
}
