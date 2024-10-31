package vendas.vendas.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vendas.vendas.Model.EstoqueModel;
import vendas.vendas.Repository.EstoqueRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class VendaService {

    private final EstoqueRepository estoqueRepository;

    public VendaService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    @Transactional
    public EstoqueModel save(EstoqueModel estoqueModel) {
        return estoqueRepository.save(estoqueModel);
    }
    @Transactional
    public boolean makeSale(String productId, String productName, Integer quantity) {
        Optional<EstoqueModel> optionalEstoque = estoqueRepository.findById(UUID.fromString(productId));

        if (optionalEstoque.isPresent()) {
            EstoqueModel estoque = optionalEstoque.get();

            if (estoque.getProductName().equals(productName) && estoque.getQuantidade() > 0) {
                estoque.setQuantidade(estoque.getQuantidade() - 1);
                estoqueRepository.save(estoque);
                return true;
            }
        }
        return false;
    }

}
