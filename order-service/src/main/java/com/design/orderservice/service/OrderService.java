package com.design.orderservice.service;

import com.design.dtoservice.order_service.OrderDto;
import com.design.orderservice.entity.Order;
import com.design.orderservice.mapper.OrderMapper;
import com.design.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public Order getOrder(Long id){
        return orderRepository.findById(id).orElseThrow();
    }

    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }

    public void addOrder(OrderDto orderDto){
        orderRepository.save(orderMapper.dtoToEntity(orderDto));
    }

}
