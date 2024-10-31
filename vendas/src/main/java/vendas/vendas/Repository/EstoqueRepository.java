package vendas.vendas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vendas.vendas.Model.EstoqueModel;

import java.util.Optional;
import java.util.UUID;

public interface EstoqueRepository extends JpaRepository<EstoqueModel, UUID> {
}
