package br.com.marketplace.api.repository;

import br.com.marketplace.api.model.RefreshToken;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends RefreshableCRUDRepository<RefreshToken, Integer> {
    Optional<RefreshToken> findByToken(String token);
}
