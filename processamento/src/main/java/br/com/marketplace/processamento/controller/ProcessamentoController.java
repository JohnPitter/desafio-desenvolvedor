package br.com.marketplace.processamento.controller;

import br.com.marketplace.processamento.request.ProcessamentoRequest;
import br.com.marketplace.processamento.response.GeneralResponse;
import br.com.marketplace.processamento.usecase.ProcessamentoUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/processamento")
public class ProcessamentoController {

    @Autowired
    ProcessamentoUseCase processamentoUseCase;

    @PostMapping
    public ResponseEntity atualizarVenda(@Valid @RequestBody ProcessamentoRequest dadosVenda) {
        try {
            return this.processamentoUseCase.atualizarVenda(dadosVenda);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(GeneralResponse.builder().mensagem(e.getMessage()).build());
        }
    }
}
