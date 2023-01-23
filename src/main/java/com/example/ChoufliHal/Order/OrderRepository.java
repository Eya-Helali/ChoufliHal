package com.example.ChoufliHal.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<MyOrder,Long> {
}
