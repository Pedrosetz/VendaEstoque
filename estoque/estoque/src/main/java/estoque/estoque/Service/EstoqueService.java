package estoque.estoque.Service;

import estoque.estoque.Dtos.EstoqueRecordDto;
import estoque.estoque.Model.EstoqueModel;
import estoque.estoque.Repository.EstoqueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EstoqueService {

    EstoqueRepository estoqueRepository;

    public EstoqueService (EstoqueRepository estoqueRepository){
        this.estoqueRepository = estoqueRepository;
    }

    @KafkaListener(topics = "estoque-topico", groupId = "estoque-group")
    public void processingSales(String mensagem) {
        System.out.println("Venda recebida: " + mensagem);
    }

    @Transactional
    public EstoqueModel save(EstoqueModel estoqueModel){
        return estoqueRepository.save(estoqueModel);
    }


    @Transactional
    public boolean updateProducts(UUID productId, EstoqueRecordDto estoqueRecordDto) {
        Optional<EstoqueModel> optionalProducts = estoqueRepository.findById(productId);
        if (optionalProducts.isPresent()) {
            EstoqueModel products = optionalProducts.get();
            products.setProductName(estoqueRecordDto.productName());
            estoqueRepository.save(products);
            return true;
        }
        return false;
    }

    @Transactional
    public Optional<EstoqueModel> findById(UUID productId) {
        return estoqueRepository.findById(productId);
    }
}
