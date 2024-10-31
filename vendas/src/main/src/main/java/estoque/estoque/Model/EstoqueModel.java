package estoque.estoque.Model;

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
    @Column(name = "product_name", nullable = false)
    private String productName;

    private int quantity;


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

    public int getQuantidade() {
        return quantity;
    }

    public void setQuantidade(int quantidade) {
        this.quantity = quantity;
    }
}
