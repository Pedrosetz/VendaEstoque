package estoque.estoque.Repository;

import estoque.estoque.Model.EstoqueModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EstoqueRepository extends JpaRepository<EstoqueModel, UUID> {
}
