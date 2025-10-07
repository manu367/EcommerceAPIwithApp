package com.ecommerce.ecommerceapi_.repo.user;

import com.ecommerce.ecommerceapi_.Model.user.UserMetadataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMetaDataRepo extends JpaRepository<UserMetadataModel, Long> {
}
