package br.com.marketplace.checkout.controller;

import br.com.marketplace.checkout.model.CustomMessage;
import br.com.marketplace.checkout.response.GeneralResponse;
import br.com.marketplace.checkout.usecase.CheckoutUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/v1/checkout")
@AllArgsConstructor
public class CheckoutController {

    private final CheckoutUseCase checkoutUseCase;

    @GetMapping
    public ResponseEntity gerarQR(@RequestParam(required = false) String id) {
        try {
            return this.checkoutUseCase.gerarQRCode();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(GeneralResponse.builder().mensagem(e.getMessage()).build());
        }
    }

    @GetMapping("/buttons")
    public ModelAndView showButtonsPage() {
        return new ModelAndView("buttons");
    }

    @PostMapping("/accept")
    public ModelAndView handleAccept() {
        // Handle accept action
        ModelAndView modelAndView = new ModelAndView("result");

        CustomMessage message = CustomMessage.builder().name("Testando").value("123").build();
        String responseKafka = checkoutUseCase.publishMessage(message);

        modelAndView.addObject("message", responseKafka);

        return modelAndView;
    }

    @PostMapping("/decline")
    public ModelAndView handleDecline() {
        // Handle decline action
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("message", "You declined!");
        return modelAndView;
    }
}
