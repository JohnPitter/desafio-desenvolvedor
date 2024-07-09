package br.com.marketplace.processamento.usecase;


import br.com.marketplace.processamento.request.ProcessamentoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class ProcessamentoUseCase {
    private final Logger logger = LoggerFactory.getLogger(ProcessamentoUseCase.class);
    public ResponseEntity atualizarVenda(ProcessamentoRequest dadosVenda) {
        return null;
    }
}