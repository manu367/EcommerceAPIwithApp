package com.ecommerce.ecommerceapi_.repo.user;

import com.ecommerce.ecommerceapi_.Model.user.UserAddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddressRepo extends JpaRepository<UserAddressModel, Long> {
}
