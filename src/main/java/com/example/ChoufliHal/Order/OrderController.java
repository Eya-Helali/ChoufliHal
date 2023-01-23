package com.example.ChoufliHal.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {


        private final OrderService orderService;

        //TODO : filters inspire toi des e-commerces + système de pagination

        @GetMapping("/allOrders")
        public List<MyOrder> getAllOrders()
        { return orderService.getAllOrders();}


        @PostMapping("/addOrder")
        public MyOrder addOrder(@RequestBody MyOrder myOrder)
        {return orderService.addOrder(myOrder);}


        @PutMapping("/update/{orderId}")
        public MyOrder updateOrderById(@RequestBody MyOrder myOrderUpdated, @PathVariable Long orderId )
        { return orderService.updateOrderById(myOrderUpdated,orderId);  }


        @DeleteMapping("/delete/{orderId}")
        public void deleteOrderById(@PathVariable Long orderId){
                orderService.deleteOrderById (orderId);
        }
    }


