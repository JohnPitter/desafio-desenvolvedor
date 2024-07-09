package br.com.marketplace.checkout.model;

import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Data
@Builder
@RedisHash("Checkout")
@AllArgsConstructor
@NoArgsConstructor
public class Checkout {

    @Id
    private Long id;

    @NotNull
    private String status;
}
