package project;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.DomainEvents;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final ProductService productService;
    private ApplicationEventPublisher publisher;


    @Autowired
    public OrderService (OrderRepository orderRepository, CustomerService customerService,ProductService productService, ApplicationEventPublisher publisher){
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.productService = productService;
        this.publisher = publisher;
    }

    public List<Order> getAllOrders(){
       return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    //Create order
    public void createNewOrder(Order order) {
        //Valid customer ID with the Customer Service. If yes, it returns customer’s address and phone number.
        String customerAddress = customerService.validCustomerId(order.getCustomerId());
        //Checks the stock quantity with the project.Product Service. If there is enough quantity in stock, the project.Product Service returns the unit price.
        int quantityNeededCustomer = order.getQuantity();
        String productName = order.getProductName();
        Double unitPrice = productService.getUnitPrice(productName, quantityNeededCustomer);
        //Next, the Order Service raises a domain event for the order, which triggers a
        //notification for the Product Service to update the stock quantity.
        if(unitPrice != null){
            OrderEvent orderEvent = new OrderEvent(order);
            orderEvent.setProductName(order.getProductName());
            orderEvent.setQuantity(order.getQuantity());
            publisher.publishEvent(orderEvent);
            orderRepository.save(order);
            System.out.println("Order placed");
        }else {
            System.out.println("Cannot place order due to insufficient stock quantity");
        }
    }

    //Delete order
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

}
