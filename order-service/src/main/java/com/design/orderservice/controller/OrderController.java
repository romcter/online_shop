package com.design.orderservice.controller;

import com.design.orderservice.entity.Order;
import com.design.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/orders/")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){
        Order order = orderService.getOrder(id);
        log.info("Order: {}", order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Order>> getAllOrder(){
//        List<Order> orders = orderService.getAllOrder();
        List<Order> orders = List.of(new Order(1L), new Order(2L), new Order(3L));
        log.info("Orders: {}", orders);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
