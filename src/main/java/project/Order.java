package project;

import javax.persistence.*;

@Entity
@Table
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private String supplier;
    private String productName;
    private int quantity;

    public Order (){
    }

    public Order(Long customerId, String supplier, String productName, int quantity) {
        this.customerId = customerId;
        this.supplier = supplier;
        this.productName = productName;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", supplier='" + supplier + '\'' +
                ", product='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
