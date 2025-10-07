package com.ecommerce.ecommerceapi_.repo.wishlist;

import com.ecommerce.ecommerceapi_.Model.wishlist.WishListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepo extends JpaRepository<WishListModel, Long> {
}
