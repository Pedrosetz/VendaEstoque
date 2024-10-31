package vendas.vendas.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TS_ESTOQUE")
public class EstoqueModel implements Serializable {
    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID productId;
    private String productName;
    private Integer quantity;

    public EstoqueModel() {}

    public EstoqueModel(UUID productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantidade() {
        return quantity;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantity = quantidade;
    }
}
