package project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.ApplicationEvent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Clock;

@Entity
public class OrderEvent {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private int quantity;

    public OrderEvent() {
    }

    public OrderEvent(Order order) {
        super();
        this.setProductName(order.getProductName());
        this.setQuantity(order.getQuantity());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
