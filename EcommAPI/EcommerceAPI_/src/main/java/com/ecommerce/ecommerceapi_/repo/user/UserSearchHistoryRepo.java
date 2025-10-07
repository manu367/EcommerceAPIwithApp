package com.ecommerce.ecommerceapi_.repo.user;

import com.ecommerce.ecommerceapi_.Model.user.UserSearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSearchHistoryRepo extends JpaRepository<UserSearchHistory, Long> {
}
