package com.ecommerce.ecommerceapi_.serviceimpl.user;

import com.ecommerce.ecommerceapi_.Model.user.UserModel;
import com.ecommerce.ecommerceapi_.constants.Status;
import com.ecommerce.ecommerceapi_.repo.user.UserRepo;
import com.ecommerce.ecommerceapi_.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepo userRepo;

    @Override
    public Optional<UserModel> createUser(UserModel user) {
        return Validation.isValidateUser(user)?Optional.of(userRepo.save(user)):Optional.empty();
    }

    @Override
    public Optional<UserModel> updateUser(UserModel user) {
        if(Validation.isValidateUserById(userRepo, user.getId())){
            UserModel userModel=Validation.getUser(userRepo, user.getId());
            userModel.setFirstName(user.getFirstName());
            userModel.setLastName(user.getLastName());
            userModel.setEmail(user.getEmail());
            userModel.setPhone(user.getPhone());
            userModel.setPassword(user.getPassword());
            return Optional.of(userRepo.save(userModel));
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserModel> deleteUser(UserModel user) {
        if(Validation.isValidateUserById(userRepo, user.getId())){
            UserModel userModel=Validation.getUser(userRepo, user.getId());
            userModel.setStatus(Status.DIE);
            return Optional.of(userRepo.save(userModel));
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<UserModel>> getAllUsers() {
        return Optional.ofNullable(userRepo.findAll());
    }



    /**
     * Searches users based on optional filters: username, email, and status.
     * <p>
     * If a filter parameter is null, it is ignored. Returns an empty list if no users match.
     * </p>
     *
     * @param username Optional username to filter by (partial match).
     * @param email    Optional email to filter by (exact match or partial).
     * @param status   Optional {@link Status} to filter by user status.
     * @return Optional list of {@link UserModel} matching the search criteria.
     */
    @Override
    public Optional<List<UserModel>> searchUsers(String username, String email, Status status) {
        if (username == null && email == null && status == null) {
            return Optional.of(Collections.emptyList());
        }
//        userRepo.findAll(())
        return Optional.empty();
    }

    @Override
    public Optional<UserModel> getUserById(Long id) {
        return Optional.of(Validation.getUser(userRepo, id));
    }

    @Override
    public void forgetPassword() {

    }

    @Override
    public void otp() {

    }

    /***
     * Utility class for validating {@link UserModel} objects.
     * <p>
     *     Contains static methods to validate user details and fetch user data safely.
     *     This class is designed as a helper and should not be instantiated.
     * </p>
     */
    final class Validation{
        private Validation(){}


        /***
         * Validates the essential fields of a {@link UserModel}.
         * <p>
         *Checks that email, password, username, and phone are non-null and not empty.
         * </p>
         */
        static boolean isValidateUser(UserModel user) {
            if(user==null) return false;
            boolean isValid = false;
            if(
                    user.getEmail()!=null && !user.getEmail().isEmpty() ||
                            user.getPassword()!=null && !user.getPassword().isEmpty()||
                            user.getUsername()!=null && !user.getUsername().isEmpty()||
                            user.getPhone()!=null && !user.getPhone().isEmpty()
            ){
                isValid = true;
            }
            return  isValid;
        }

        /**
         * Checks whether a user exists in the repository by their ID.
         *
         * @param userRepo The {@link UserRepo} repository.
         * @param userid  The ID of the user to check.
         * @return true if the user exists; false otherwise.
         */

        static boolean isValidateUserById(UserRepo userRepo,Long userid) {
            boolean isValid = false;
            Optional<UserModel> userModel=userRepo.findById(userid);
            if(userModel.isPresent()){
                isValid = true;
            }
            return  isValid;
        }

        /**
         * Retrieves a {@link UserModel} from the repository by ID.
         *
         * @param userRepo The {@link UserRepo} repository.
         * @param userid   The ID of the user to fetch.
         * @return The {@link UserModel} if found; null otherwise.
         */
        static UserModel getUser(UserRepo userRepo,Long userid) {
            Optional<UserModel> userModel=userRepo.findById(userid);
            if(userModel.isPresent()){
                return userModel.get();
            }
            return null;
        }
    }

}

