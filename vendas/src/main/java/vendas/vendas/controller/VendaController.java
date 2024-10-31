package vendas.vendas.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import vendas.vendas.Dtos.VendasRecordDto;
import vendas.vendas.Model.EstoqueModel;
import vendas.vendas.Service.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaController {
    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final VendaService vendaService;

    public VendaController(KafkaTemplate<String, String> kafkaTemplate, VendaService vendaService) {
        this.kafkaTemplate = kafkaTemplate;
        this.vendaService = vendaService;
    }


    @PostMapping
    public ResponseEntity<String> makeSale(@RequestBody @Valid VendasRecordDto vendasRecordDto) {
        boolean success = vendaService.makeSale(vendasRecordDto.productId(), vendasRecordDto.productName(), vendasRecordDto.quantity());

        if (success) {
            kafkaTemplate.send("estoque-topico", vendasRecordDto.productId());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto não disponível ou nome inválido.");
        }
    }
}
