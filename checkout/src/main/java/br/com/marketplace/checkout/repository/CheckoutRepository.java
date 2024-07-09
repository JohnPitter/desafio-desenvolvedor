package br.com.marketplace.checkout.repository;

import br.com.marketplace.checkout.model.Checkout;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends CrudRepository<Checkout, String> {
    Optional<Checkout> findById(Long id);
}