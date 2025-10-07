package com.ecommerce.ecommerceapi_.service.user;

import com.ecommerce.ecommerceapi_.Model.user.UserCouponsModel;
import com.ecommerce.ecommerceapi_.Model.user.UserModel;
import com.ecommerce.ecommerceapi_.constants.Status;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<UserModel> createUser(UserModel user);
    Optional<UserModel> updateUser(UserModel user);
    Optional<UserModel> deleteUser(UserModel user);
    Optional<List<UserModel>> getAllUsers();

    Optional<List<UserModel>> searchUsers(String username, String email, Status status);

    Optional<UserModel> getUserById(Long id);

    void forgetPassword();
    void otp();
}
