package br.com.marketplace.api.service;

import br.com.marketplace.api.model.Venda;
import br.com.marketplace.api.repository.MarketPlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MarketPlaceService {
    private MarketPlaceRepository marketPlaceRepository;
    public Venda cadastrarVenda(Venda venda) {
        return this.marketPlaceRepository.save(venda);
    }
}
