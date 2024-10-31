package estoque.estoque.Controller;

import estoque.estoque.Dtos.EstoqueRecordDto;
import estoque.estoque.Model.EstoqueModel;
import estoque.estoque.Repository.EstoqueRepository;
import estoque.estoque.Service.EstoqueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping
    public ResponseEntity<EstoqueModel> addProducts(@RequestBody @Valid EstoqueRecordDto estoqueRecordDto) {
        EstoqueModel estoqueModel = new EstoqueModel();
        estoqueModel.setProductName(estoqueRecordDto.productName());
        estoqueModel.setQuantidade(estoqueRecordDto.quantity());

        EstoqueModel saveProducts = estoqueService.save(estoqueModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveProducts);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> updateProducts(@PathVariable UUID productId, @RequestBody @Valid EstoqueRecordDto estoqueRecordDto) {
        boolean updated = estoqueService.updateProducts(productId, estoqueRecordDto);
        if (updated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<EstoqueModel> getEstoqueId(@PathVariable UUID productId) {
        Optional<EstoqueModel> estoque = estoqueService.findById(productId);
        return estoque.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}




