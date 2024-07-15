package br.com.marketplace.api.repository;

import br.com.marketplace.api.model.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends RefreshableCRUDRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);
    UserInfo findFirstById(Long id);
}
