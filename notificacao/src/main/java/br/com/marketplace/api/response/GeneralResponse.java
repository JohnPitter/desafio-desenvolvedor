package br.com.marketplace.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Setter
public class GeneralResponse {
    private String mensagem;

    public String getMensagem() {
        return mensagem.contains(":") ? mensagem.split(":")[1].substring(1) : mensagem;
    }
}
