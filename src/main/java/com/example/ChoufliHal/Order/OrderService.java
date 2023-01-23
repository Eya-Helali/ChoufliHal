package com.example.ChoufliHal.Order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {


      private final OrderRepository orderRepository;

        public List<MyOrder> getAllOrders() {
            return orderRepository.findAll();
        }

       public MyOrder addOrder(MyOrder myOrder) {
            return  orderRepository.save(myOrder);
        }

        public MyOrder updateOrderById(MyOrder myOrderUpdated, Long ordertId) {
            myOrderUpdated.setOrderId(ordertId);
            return orderRepository.save(myOrderUpdated);
        }

        public void deleteOrderById(Long orderId) {
        orderRepository.deleteById(orderId);

    }

}
