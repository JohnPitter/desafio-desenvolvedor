package br.com.marketplace.checkout.service;

import br.com.marketplace.checkout.model.Checkout;
import br.com.marketplace.checkout.repository.CheckoutRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    @Autowired
    private CheckoutRepository checkoutRepository;

    public Checkout criarCheckout(Checkout user) {
        return checkoutRepository.save(user);
    }

    public Checkout getUserById(String id) {
        return checkoutRepository.findById(id).orElse(null);
    }
}
