package br.com.marketplace.checkout.usecase;

import br.com.marketplace.checkout.model.CustomMessage;
import br.com.marketplace.checkout.service.KafkaProducerService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


@Component
public class CheckoutUseCase {

    private final Logger logger = LoggerFactory.getLogger(CheckoutUseCase.class);
    
    @Autowired
    private KafkaProducerService producerService;

    public ResponseEntity<byte[]> gerarQRCode() throws WriterException, IOException {
        String qrContent = "https://www.google.com";
        int width = 300;
        int height = 300;
            
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(qrContent, BarcodeFormat.QR_CODE, width, height);
    
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
    
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
    
        return new ResponseEntity<>(pngData, headers, HttpStatus.OK);
    }

    public String publishMessage(@RequestBody CustomMessage message) {
        producerService.sendMessage(message);
        return "Message sent to Kafka topic";
    }

}




