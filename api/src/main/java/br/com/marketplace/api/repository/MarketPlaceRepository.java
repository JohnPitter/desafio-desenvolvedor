package br.com.marketplace.api.repository;

import br.com.marketplace.api.model.Venda;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MarketPlaceRepository extends JpaRepository<Venda, Long> {
    Optional<Venda> findById(Long id);
}