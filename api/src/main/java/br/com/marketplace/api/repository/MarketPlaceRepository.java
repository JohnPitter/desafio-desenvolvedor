package br.com.marketplace.api.repository;

import br.com.marketplace.api.model.Venda;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface MarketPlaceRepository extends CrudRepository<Venda, Long> {
    Optional<Venda> findById(Long id);
}