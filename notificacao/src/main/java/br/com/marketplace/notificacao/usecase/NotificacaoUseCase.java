package br.com.marketplace.notificacao.usecase;


import br.com.marketplace.notificacao.service.NotificacaoService;
import br.com.marketplace.notificacao.response.GeneralResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class NotificacaoUseCase {

    private final Logger logger = LoggerFactory.getLogger(NotificacaoUseCase.class);

    @Autowired
    private NotificacaoService notificacaoService;

    public ResponseEntity mensagemEmail() {
        return ResponseEntity.ok().body(br.com.marketplace.notificacao.response.GeneralResponse.builder().mensagem("Mensagem via e-mail enviada.").build());
    }

    public ResponseEntity mensagemWhatsapp() {
        return ResponseEntity.ok().body(GeneralResponse.builder().mensagem("Mensagem via Whatsapp enviada.").build());
    }
}