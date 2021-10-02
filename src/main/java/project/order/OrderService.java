package project.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import project.customer.Customer;
import project.customer.CustomerService;
import project.product.Product;
import project.product.ProductService;

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
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    //Create order
    public Double createNewOrder(Order order) {
        //Valid customer ID with the Customer Service. If yes, it returns customer’s address and phone number.
        String customerAddress = customerService.validCustomerId(order.getCustomerId());
        //Checks the stock quantity with the project.product.Product Service. If there is enough quantity in stock, the project.product.Product Service returns the unit price.
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
            return unitPrice;
        }
        return null;
    }

    //Delete order
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

    //Look up customer info by order
    public Customer getCustomerInfoByOrderId(Long orderId){
        Order order = getOrderById(orderId);
        Long customerId = order.getCustomerId();
        return customerService.getCustomerById(customerId);
    }

    //Look up product info by order
    public Product getProductInfoByOrderId(Long orderId){
        Order order = getOrderById(orderId);
        String productName = order.getProductName();
        return productService.getProductByName(productName);
    }

}
