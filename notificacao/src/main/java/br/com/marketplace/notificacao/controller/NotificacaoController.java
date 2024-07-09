package br.com.marketplace.notificacao.controller;

import br.com.marketplace.notificacao.response.GeneralResponse;
import br.com.marketplace.notificacao.usecase.NotificacaoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/notificacao")
public class NotificacaoController {

    @Autowired
    NotificacaoUseCase notificacaoUseCase;

    @PostMapping("email")
    public ResponseEntity notificarEmail() {
        try {
            return this.notificacaoUseCase.mensagemEmail();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(GeneralResponse.builder().mensagem(e.getMessage()).build());
        }
    }

    @PostMapping("whats")
    public ResponseEntity notificarWhats() {
        try {
            return this.notificacaoUseCase.mensagemWhatsapp();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(GeneralResponse.builder().mensagem(e.getMessage()).build());
        }
    }
}
