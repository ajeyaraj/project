package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class  OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/addOrder")
    public void createNewOrder(@RequestBody Order newOrder) {
        Double price = orderService.createNewOrder(newOrder);
        if(price != null){
            int quantity = newOrder.getQuantity();
            double totalPrice = price * quantity;
            System.out.println("Order placed. The total order price is " + totalPrice );
        }else {
            System.out.println("Cannot place order due to insufficient stock quantity");
        }
    }
}
