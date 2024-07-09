package br.com.marketplace.api.controller;

import br.com.marketplace.api.request.VendaRequest;
import br.com.marketplace.api.response.GeneralResponse;
import br.com.marketplace.api.usecase.MarketPlaceUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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


    @GetMapping("/checkout")
    public ResponseEntity redirectCheckout(@RequestParam(required = false) Long idVenda) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI("http://localhost:8082/v1/checkout"));
            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(GeneralResponse.builder().mensagem(e.getMessage()).build());
        }
    }
}
