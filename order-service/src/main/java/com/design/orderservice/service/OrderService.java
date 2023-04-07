package com.design.orderservice.service;

import com.design.orderservice.entity.Order;
import com.design.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrder(Long id){
        return orderRepository.findById(id).orElseThrow();
    }

    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }
}
