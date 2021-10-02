package project;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    //private final ProductService productService;

    @Autowired
    public OrderService (OrderRepository orderRepository, CustomerService customerService){
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        //this.productService = productService;
    }

    public List<Order> getAllOrders(){
       return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    //Create order
    public void createNewOrder(Order order) throws CustomerNotFoundException{
        //Valid customer ID with the Customer Service.
        //If yes, it returns customer’s address and phone number.
        String customerAddress = customerService.validCustomerId(order.getCustomerId());
        //Checks the stock quantity with the Product Service.
        //If there is enough quantity in stock, the Product Service returns the unit price
        //int unitPrice = productService.checkProductQuantity(order.getProductName());
    }

    //Delete order
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

}
