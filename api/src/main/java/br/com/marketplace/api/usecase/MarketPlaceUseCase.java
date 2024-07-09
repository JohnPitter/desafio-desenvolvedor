package br.com.marketplace.api.usecase;


import br.com.marketplace.api.request.VendaRequest;
import br.com.marketplace.api.service.MarketPlaceService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class MarketPlaceUseCase {

    private final Logger logger = LoggerFactory.getLogger(MarketPlaceUseCase.class);

    private MarketPlaceService marketplaceService;

    public ResponseEntity realizarVenda(VendaRequest dadosVenda) {
        return null;
    }
}