package br.com.marketplace.api.controller;

import br.com.marketplace.api.request.VendaRequest;
import br.com.marketplace.api.response.GeneralResponse;
import br.com.marketplace.api.usecase.MarketPlaceUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/marketplace")
@AllArgsConstructor
public class MarketPlaceController {

    private final MarketPlaceUseCase marketplaceUseCase;

    @PostMapping
    public ResponseEntity cadastrarVendas(@Valid @RequestBody VendaRequest dadosAgendamento) {
        try {
            return this.marketplaceUseCase.realizarVenda(dadosAgendamento);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(GeneralResponse.builder().mensagem(e.getMessage()).build());
        }
    }
}
